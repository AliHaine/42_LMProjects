#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void no()
{
    puts("Nope.");
    exit(1);
}

void ok()
{
    puts("Good job.");
}

int main(int32_t argc, char** argv)
{
    int32_t var_c = 0;
    printf("Please enter key: ");
    char var_39;

    if (1 != __isoc99_scanf("%23s", &var_39))
        no();

    char var_38;

    if (0x30 != var_38)
        no();

    if (0x30 != var_39)
        no();

    fflush(*stdin);
    char var_21[9];
    memset(&var_21, 0, 9);
    var_21 = 0x64;
    char var_3a = 0;
    int32_t var_18 = 2;
    int32_t var_14 = 1;

    while (true)
    {
        char var_45_1 = 0;
        int32_t eax_3;

        if (strlen(var_21) < 8)
        {
            eax_3 = var_18 < strlen(&var_39);
            var_45_1 = eax_3;
        }

        eax_3 = var_45_1;

        if ((eax_3 & 1) == 0)
            break;

        int32_t eax_6;
        eax_6 = &var_39[var_18];
        char nptr = eax_6;
        int32_t eax_7;
        eax_7 = &var_38[var_18];
        char var_3c_1 = eax_7;
        void var_37;
        int32_t eax_8;
        eax_8 = *(&var_37 + var_18);
        char var_3b_1 = eax_8;
        &var_21[var_14] = atoi(&nptr);
        var_18 += 3;
        var_14 += 1;
    }

    &var_21[var_14] = 0;

    if (strcmp(&var_21, "delabere") != 0)
        no();

    ok();
    return 0;
}
