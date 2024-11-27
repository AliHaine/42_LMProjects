#include <stdio.h>
#include <string.h>

int main()
{
    char local0[] = "__stack_check";
	char local1[14];

	printf("Please enter key: ");
    scanf("%s", local1);
    if (strcmp(local1, local0) != 0)
        printf("Nope.\n");
    else
        printf("Good job.\n");
    return 0;
}