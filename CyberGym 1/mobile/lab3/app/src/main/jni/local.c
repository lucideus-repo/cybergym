#include <jni.h>
#include <stdio.h>

JNIEXPORT jstring JNICALL
Java_com_moksh_lab3_t_k1(JNIEnv *env, jobject instance) {
    char *s1 = "qLF3j8BVaMugzU5NuVhUYs1jUrVh2";
    char *s2 = "GK3HZXJmIns4xzWN14GBQLrylYPpw";
    char *s3 = "XDKNJD8X8EUNBllnkq9igiwXi5Hdd";
    char *s4 = "xolRpWIe9aDKAfgk8lfa8FNG8qqpQ";
    char *s5 = "BXKNFqjs3cjeJyRrAwDKfLKwBArSp";
    char *s6 = "DyZq7EhrJxx0J1UNDXslJ1uVujDOL";
    char *s7 = "xakGHsTw0IzuZdNuoVnIm8gLkK2ET";
    char *s8 = "9ILX46kZ7WgYrhrQZiv53kf2dcAIY";
    char *s9 = "MldeklXNtY1bUrwHDYrg669eE95Jc";
    char *s10= "Tuhn8obPhmwmU70QLyhWmDjUQKY05";
 return (*env)->  NewStringUTF(env, "546d463061585a6c4e57566a636d56305545427a63336377636d5178");
}

JNIEXPORT jstring JNICALL
Java_com_moksh_lab3_t_k2(JNIEnv *env, jobject instance) {
    char *s1 = "oghYsLZomn1_z5K3XPTB1r8ansI7k";
    char *s2 = "72aLbOr4VJQYdJCj0zyvXRo0mm4Je";
    char *s3 = "v6TlskU63WW72eoQRKDnG5xMIcdLi";
    char *s4 = "r4T3fO0ea6x0thvY97CmatF8TGo7r";
    char *s5 = "LdSVd_bMfE787C8lBcxqkX80v8fKx";
    char *s6 = "Z7BLL3aqav6SsYgEoPOhsqkuHt2jB";
    char *s7 = "wfQfLz1d4NBgBe87wsknpgYxZWSxE";
    char *s8 = "WLaIe1GZiFShXtRy7w_qH1BQKaXzP";
    char *s9 = "48IViRf2Lrr10aMku3cyypcxitdRr";
    char *s10= "ZVRXFWu34uFIs4dTWQ6TtmLYZCPXs";
    int l = 23;
    char sx[l];
    int x = 0,y=0;
    int j;
    for(j = l-1;j>-1;j-=1){
        if(y == 10){
            y =0;
        }
        switch(y){
            case 0: sx[x] = s1[x+1];
                break;
            case 1: sx[x] = s2[x+1];
                break;
            case 2: sx[x] = s3[x+1];
                break;
            case 3: sx[x] = s4[x+1];
                break;
            case 4: sx[x] = s5[x+1];
                break;
            case 5: sx[x] = s6[x+1];
                break;
            case 6: sx[x] = s7[x+1];
                break;
            case 7: sx[x] = s8[x+1];
                break;
            case 8: sx[x] = s9[x+1];
                break;
            case 9: sx[x] = s10[x+1];
                break;
        }
        x +=1;
        y +=1;
    }
    for(int t =0, u = l-1;t<u;t++,u--){
        char tmp = sx[t];
        sx[t] = sx[u];
        sx[u] = tmp;
    }
    char sy[(l*2)+1];
    int m = 0;
    int n=0;
    while(sx[m] != '\0'){
        sprintf((char*)(sy+n),"%02X", sx[m]);
        m+=1;
        n+=2;
    }
    sy[n++] = '\0';

 return (*env)->NewStringUTF(env, sy);
}