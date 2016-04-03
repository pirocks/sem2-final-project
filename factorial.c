#include <stdio.h>


int factorial(int);



int main()
{
	volatile int var;
	for(int i = 0; i < 1000000;i++)
	{
		var = factorial(25);
		printf("factorial:%d\n",var);
	}
	return 0;
}

int factorial(int n)
{
	if(n == 1)
		return 1;
	return(n*factorial(n-1));
}
