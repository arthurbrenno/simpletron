
![App Screenshot](https://media.discordapp.net/attachments/815753127537410102/1103338145765924864/Captura_de_tela_2023-05-03_121046.png?width=825&height=429)


# [🤖] Simpletron ML

The Simpletron is a computer that runs programs in its native language: Simpletron Machine Language (SML). It has an accumulator for storing information used in calculations and a 100-word memory. 

Each word is a signed four-digit decimal number. SML programs are loaded into memory starting at location 00 and each instruction occupies one word. Instructions have a plus sign, while data words can have either plus or minus signs. 

The first two digits of an instruction are the operation code and the last two digits are the operand, which is the address of the memory location containing the word to which the operation applies.

## Commands

| Value | Description |
|-------|-------------|
| 10    | Read a word from the keyboard into a specific location in memory. |
| 11    | Write a word from a specific location in memory to the screen. |
| 20    | Load a word from a specific location in memory into the accumulator. |
| 21    | Store a word from the accumulator into a specific location in memory. |
| 30    | Add a word from a specific location in memory to the word in the accumulator (leave the result in the accumulator). |
| 31    | Subtract a word from a specific location in memory from the word in the accumulator (leave the result in the accumulator). |
| 32    | Divide a word from a specific location in memory into the word in the accumulator (leave result in the accumulator). |
| 33    | Multiply a word from a specific location in memory by the word in the accumulator (leave the result in the accumulator). |
| 40    | Branch to a specific location in memory. |
| 41    | Branch to a specific location in memory if the accumulator is negative. |
| 42    | Branch to a specific location in memory if the accumulator is zero. |
| 43    | Halt. The program has completed its task. |

## Installation

You can use git to clone the repository

```bash
git clone https://github.com/arthurbrenno/simpletron.git
```
Or just download it as a .zip

Code ---> Download zip


## Executing
You can Execute by opening the .exe at
```bash
Simpletron\SimpletronExecute.bat
```

## Contributing

Pull requests are always welcome. For major changes, please open an issue first
to discuss what you would like to change.

## License

[MIT](https://choosealicense.com/licenses/mit/)

