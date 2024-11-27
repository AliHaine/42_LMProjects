#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

void no()
{
    puts("Nope.");
    exit(1);
}

void ok()
{
    puts("Good job.");
}

//pass = 0010110897w98*101114101
int main()
{
    uint uVar1;
    size_t sVar2;
    bool while_exit;
    char while_str[4];
    char local_39[24];
    char str_9[9];
    int scanf_ret;
    int atoi_ret;

    printf("Please enter key: ");
    scanf_ret = scanf("%s", local_39);
    if (scanf_ret != 1)
        no();
    if (local_39[1] != '0')
        no();
    if (local_39[0] != '0')
        no();
    fflush(stdin);
    memset(str_9, 0,9);
    str_9[0] = 'd';
    while_str[3] = 0;
    int i = 2;
    int j = 1;
    while(true) {
        sVar2 = strlen(str_9);
        uVar1 = i;
        while_exit = false;
        if (sVar2 < 8) {
            sVar2 = strlen(local_39);
            while_exit = uVar1 < sVar2;
        }
        if (!while_exit) break;
        while_str[0] = local_39[i];
        while_str[1] = local_39[i + 1];
        while_str[2] = local_39[i + 2];
        atoi_ret = atoi(while_str);
        str_9[j] = (char)atoi_ret;
        i += 3;
        j += 1;
    }
    str_9[j] = '\0';
    if (strcmp(str_9, "delabere") == 0)
        ok();
    else
        no();
    return 0;
}
