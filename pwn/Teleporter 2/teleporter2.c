#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>
#include <string.h>

void x() {
	setvbuf(stdout, NULL, _IONBF, 0);
	setvbuf(stdin, NULL, _IONBF, 0);
	setvbuf(stderr, NULL, _IONBF, 0);
}

void x4(int sig) {
  if (sig == SIGALRM) {
  	printf("[!] Get Out");
    _exit(0);
  }
}

void x1() {
	signal(SIGALRM, x4);
	alarm(60);
}

void x3() {
    system("/bin/rbash");
}

void x2() {
    char read_buf[0xff];
    printf("Name please:\n");
    gets(read_buf);
    printf(read_buf);
}

void x5() {
    char read_buf[0xff];
    printf("'s Secret:\n");
    gets(read_buf);
    if(strcmp(read_buf, "it5 a b1g 5t0ry ") == 0) {
        printf("Baz!nga\ncat flag.txt");
    } else {
        printf("May be next time ;)\n");
        _exit(0);
    }
}

void main(int argc, char* argv[]) {
	x();
	x1();
    x2();
    x5();
}
