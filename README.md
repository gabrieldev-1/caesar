# 🏛️ Caesar Cipher CLI

<p align="center">
  <pre>
    /$$$$$$                                                   
    /$$__  $$                                                  
    | $$  \\__/  /$$$$$$   /$$$$$$   /$$$$$$$  /$$$$$$   /$$$$$$ 
    | $$       |____  $$ /2$$__  $$ /$$_____/ |____  $$ /$$__  $$
    | $$        /$$$$$$$| $$$$$$$$|  $$$$$$   /$$$$$$$| $$  \\__/
    | $$    $$ /$$__  $$| $$_____/ \\____  $$ /$$__  $$| $$      
    |  $$$$$$/|  $$$$$$$|  $$$$$$$ /$$$$$$$/|  $$$$$$$| $$      
    \\______/  \\_______/ \\_______/|_______/  \\_______/|__/
                                             Caesar v1.2
                                             Author: gabrieldev-1   
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
##🚀 sUsage

You can use Caesar Cipher CLI as a global command or by running the JAR file directly.

caesar <flag> <input_file> [key] [output_file]

**Flags**

    -e : Encrypt the file.

    -d : Decrypt the file.

    -b : Brute Force attack (no key needed).

    -h : Show help message.

**Examples**
1. Encryption & Decryption

For basic encryption or decryption, you must provide a numeric key.

In-place (Modifies the original file):

# Encrypts secret.txt using key 15
caesar -e secret.txt 15

New Output File:

# Decrypts secret.txt to a new file named plain.txt
caesar -d secret.txt 15 plain.txt

2. Brute Force Attack

If you found an encrypted file but don't know the key, use the -b flag. The program will generate all 25 possible variations for you to analyze.

caesar -b mystery_file.txt

3. Running without global command

If you haven't added the program to your PATH, use the Java command:

java -jar caesar.jar -e message.txt 7

## 💡 Pro Tip for Linux Users

If you are using the terminal, you can chain commands. For example, to encrypt and then immediately protect the file:

caesar -e passwords.txt 22 && chmod 400 passwords.txt