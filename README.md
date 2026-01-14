# 🏛️ Caesar Cipher CLI

<p align="center">
  <pre>
  /$$$$$$                                                   
 /$$__  $$                                                  
| $$  \__/  /$$$$$$   /$$$$$$   /$$$$$$$  /$$$$$$   /$$$$$$ 
| $$      |____ $$ /$$__  $$/$$_____/ |____ $$ /$$__  $$
| $$       /$$$$$$$|$$$$$$$$|  $$$$$$  /$$$$$$$|$$  \__/
| $$  $$ /$$__  $$| $$_____/ \____  $$/$$__ $$| $$      
|  $$$$$$/|  $$$$$$$|  $$$$$$$/$$$$$$$/| $$$$$$$| $$      
 \______/  \_______/ \_______/|_______/  \_______/|__/      
  </pre>
</p>

**Caesar** is a Java-based Command Line Interface (CLI) tool designed to encrypt and decrypt text files using the classic **Caesar Cipher**. This project was built to practice file I/O operations, core programming logic, and Linux environment automation.

## 🚀 Features

- 🔒 **Encryption:** Convert plaintext files into ciphertext.
- 🔓 **Decryption:** Recover original content using a specific key.
- 📂 **File Processing:** Direct reading and writing to the file system.
- 🐧 **Linux Integration:** Designed to work globally via terminal.

## 🧠 How it works

The Caesar Cipher is a substitution technique where each letter in the plaintext is replaced by a letter some fixed number of positions down the alphabet.
The implementation follows this formula:

$$f(x) = (x + n) \pmod{26}$$



## 🛠️ Tech Stack

- **Language:** Java 17+
- **Editor:** Vim
- **OS:** Linux (Ubuntu/Debian/Arch)
- **Version Control:** Git

## 📥 Installation & Build

To "install" Caesar globally on your Linux system, follow these steps:

1. **Clone the repository:**
   ```bash
   git clone [https://github.com/gabrieldev-1/caesar.git](https://github.com/gabrieldev-1/caesar.git)
   cd caesar
2. **Compile and generate the JAR file**
    ```mkdir bin
    javac -d bin src/*.java
    jar cfe caesar.jar Main -C bin.
3. **Create a global command**
    ```# Update the path below to your actual project directory
    sudo echo -e "#!/bin/bash\njava -jar $(pwd)/caesar.jar \"\$@\"" > /usr/local/bin/caesar
    sudo chmod +x /usr/local/bin/caesar
## Usage
    ```caesar -h
    caesar -e <message.txt> <key> <secret.txt>
    caesar -d <secret.txt> <key> <mesage.txt>