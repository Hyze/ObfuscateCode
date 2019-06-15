# Obfuscate String XOR
This script can obfuscate any strings

## Requirements

You will need to install : 

SDKMAN :

```bash
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
```

Kotlin & Kscript :

```bash
sdk install kotlin
sdk install kscript
```

## Usage

Once you download the script, make it executable

```bash
chmod +x Obfuscate.kts
```

and then 

```
./Obfuscate.kts <string you want to hide >
```

The program will return the method to de-obfuscate the string
