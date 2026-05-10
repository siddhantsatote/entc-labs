import argparse
import os
import shutil
import sys
try:
    import pkg_resources
    _HAS_PKG_RESOURCES = True
except Exception:
    _HAS_PKG_RESOURCES = False
from colorama import init, Fore, Style

init(autoreset=True)

from typing import List

def experiments_dir() -> str:
    if _HAS_PKG_RESOURCES:
        try:
            return pkg_resources.resource_filename('entc_labs', 'experiments')
        except Exception:
            pass
    # Fallback to package-relative experiments folder (works when running from source)
    return os.path.join(os.path.dirname(__file__), 'experiments')

def list_experiments() -> List[str]:
    path = experiments_dir()
    try:
        items = sorted([d for d in os.listdir(path) if os.path.isdir(os.path.join(path, d))])
    except Exception:
        items = []
    return items

def prompt_overwrite(path: str) -> bool:
    resp = input(f"Destination '{path}' exists — overwrite? [y/N]: ").strip().lower()
    return resp == 'y' or resp == 'yes'

def copy_with_progress(src: str, dst: str) -> None:
    total = 0
    for _root, _dirs, files in os.walk(src):
        total += len(files)

    if total == 0:
        shutil.copytree(src, dst)
        print(Fore.GREEN + f"Copied {src} -> {dst}")
        return

    counter = {'i': 0}

    def _copy_fn(s, d):
        shutil.copy2(s, d)
        counter['i'] += 1
        print(f"[{counter['i']}/{total}] {os.path.relpath(s, src)}")

    shutil.copytree(src, dst, copy_function=_copy_fn)
    print(Fore.GREEN + f"Finished copying {src} -> {dst}")

def install_all(dest_base: str) -> None:
    exp_dir = experiments_dir()
    exps = list_experiments()
    if not exps:
        print(Fore.RED + "No experiments found in package.")
        return

    for e in exps:
        src = os.path.join(exp_dir, e)
        dst = os.path.join(dest_base, e)
        if os.path.exists(dst):
            if prompt_overwrite(dst):
                shutil.rmtree(dst)
            else:
                print(Fore.YELLOW + f"Skipped {e}")
                continue
        print(Style.BRIGHT + f"Installing {e}...")
        copy_with_progress(src, dst)

def install_one(exp_name: str, dest_base: str) -> None:
    exp_dir = experiments_dir()
    src = os.path.join(exp_dir, exp_name)
    if not os.path.isdir(src):
        print(Fore.RED + f"Experiment '{exp_name}' not found.")
        return
    dst = os.path.join(dest_base, exp_name)
    if os.path.exists(dst):
        if prompt_overwrite(dst):
            shutil.rmtree(dst)
        else:
            print(Fore.YELLOW + f"Skipped {exp_name}")
            return
    print(Style.BRIGHT + f"Installing {exp_name}...")
    copy_with_progress(src, dst)

def info() -> None:
    from entc_labs import version, author
    exps = list_experiments()
    print(f"Version: {version}")
    print(f"Author: {author}")
    print(f"Total experiments: {len(exps)}")

def main(argv=None):
    parser = argparse.ArgumentParser(prog='entc-labs', description='ENtc Labs experiment distributor')
    sub = parser.add_subparsers(dest='cmd')

    sub_install = sub.add_parser('install', help='Install all experiments into current directory')
    sub_install.add_argument('--dest', '-d', default=os.getcwd(), help='Destination directory (default: current dir)')

    sub_list = sub.add_parser('list', help='List available experiments')

    sub_get = sub.add_parser('get', help='Get a single experiment')
    sub_get.add_argument('exp', help='Experiment folder name, e.g. exp3')
    sub_get.add_argument('--dest', '-d', default=os.getcwd(), help='Destination directory (default: current dir)')

    sub_info = sub.add_parser('info', help='Show package info')

    args = parser.parse_args(argv)

    if args.cmd == 'install':
        install_all(args.dest)
    elif args.cmd == 'list':
        exps = list_experiments()
        if not exps:
            print(Fore.RED + 'No experiments found')
            return
        for e in exps:
            print(Fore.GREEN + e)
    elif args.cmd == 'get':
        install_one(args.exp, args.dest)
    elif args.cmd == 'info':
        info()
    else:
        parser.print_help()

if __name__ == '__main__':
    main()
