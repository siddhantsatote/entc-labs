from setuptools import setup, find_packages

setup(
    name='entc-labs',
    version='1.0.0',
    author='Siddh',
    description='Distribute Verilog HDL experiments for ENTC FPGA course',
    packages=find_packages(exclude=('tests',)),
    include_package_data=True,
    python_requires='>=3.8',
    install_requires=[
        'colorama',
    ],
    entry_points={
        'console_scripts': [
            'entc-labs=entc_labs.cli:main',
        ]
    },
)
