# entc-labs

Small Python package and CLI to distribute Verilog HDL experiment folders for a college FPGA course.

## Quick Install (Any Windows PC)

**Option 1: Run the installer script (easiest)**
- Download `install-entc-labs.bat` (or `install-entc-labs.ps1` for PowerShell)
- Double-click to run
- All experiments will be downloaded to the current folder

**Option 2: One-liner command (PowerShell)**
```powershell
python -m pip install --user git+https://github.com/siddhantsatote/entc-labs.git; python -m entc_labs.cli install --dest .
```

**Option 3: Manual step-by-step**
```powershell
python -m pip install --user git+https://github.com/siddhantsatote/entc-labs.git
python -m entc_labs.cli install --dest .
```

## Requirements
- Python 3.8+ (download from https://www.python.org)
- Windows 7 or later
- Internet connection (to download from GitHub)

## CLI Usage

After installation, use these commands:

- `entc-labs install` — downloads all experiments to current directory
- `entc-labs get exp3` — downloads only experiment 3
- `entc-labs list` — lists all available experiments
- `entc-labs info` — shows version, author, and total experiments

### Examples
```powershell
# List available experiments
entc-labs list

# Copy specific experiment
entc-labs get exp2

# Copy all experiments to a custom folder
entc-labs install --dest C:\MyExperiments

# Show package info
entc-labs info
```

## Troubleshooting

**"entc-labs: command not found"**
- Use: `python -m entc_labs.cli install --dest .`
- Or add Python Scripts folder to PATH

**"Python not found"**
- Install Python 3.8+ from https://www.python.org
- Make sure "Add Python to PATH" is checked during installation

**"Permission denied"**
- Use `--user` flag: `python -m pip install --user git+...`
- Or run PowerShell/Command Prompt as Administrator
### Method 1: SETUP.bat (Easiest - Works Everywhere!)

1. **Download:** `SETUP.bat` from this repository
2. **Double-click** the file (right-click → Open with Command Prompt if needed)
3. **Wait** for it to install everything automatically
4. **Done!** All experiments downloaded to current folder

This works even if you don't have Git or don't know what pip is. The script does everything!

### Method 2: PowerShell Script (If you prefer PowerShell)

```powershell
# Right-click on SETUP.ps1 → Run with PowerShell
# Or run manually:
powershell -ExecutionPolicy Bypass -File SETUP.ps1
```

### Method 3: Manual Install (For Advanced Users)

```powershell
# Install dependencies
python -m pip install --user colorama setuptools wheel

# Install entc-labs package from GitHub
python -m pip install --user git+https://github.com/siddhantsatote/entc-labs.git

# Download all experiments
python -m entc_labs.cli install --dest .
```
