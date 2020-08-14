#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>
#include <string.h>

// gcc pwn1.c -o pwn1 -no-pie -fno-stack-protector

void buff() {
    setvbuf(stdout, NULL, _IONBF, 0);
    setvbuf(stdin, NULL, _IONBF, 0);
    setvbuf(stderr, NULL, _IONBF, 0);}

void k(int sig) {
  if (sig == SIGALRM) {
    puts("[!] What are you waiting for...!");
    _exit(0);}}

void ssig() {
    signal(SIGALRM, k);
    alarm(43);}

void x() {system("/bin/rbash");}

void f() {
    char read[0xff];
    printf("Secret Please:");
    gets(read);
    if(strcmp(read, "Ho1d_4h3_D00r! ") == 0) {
        puts("I failed. Good. Now go fail again.");
    system("date");
    } else {
        puts("Acess Denied");
        _exit(0);}}

void main(int argc, char* argv[]) {
    buff();
    ssig();
    f();}