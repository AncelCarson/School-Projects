// Ancel Carson
// COSC3503-01
// 3/25/20

#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

void *avg_func(void *str);
void *min_func(void *str);
void *max_func(void *str);

double avg;
int min;
int max;

typedef struct datastruct
{
    int size;
    int * values;
}datastruct;

main(int argc, char *argv[])
{
    while(argc <=1 )
    {
        println("Input formatting error.");
        exit (0);
    }

    int t1, t2, t3;
    int vals[argc-1];
    pthread_t thread1, thread2, thread3;

    for(int i = 0; i < (argc-1); i++)
    {
        vals[i] = atoi(argv[i+1]);
    }

    const char *message1 = "This is thread 1";
    const char *message2 = "This is thread 2";
    const char *message3 = "This is thread 3";
    printf("Running %s\n\n", argv[0]);

    datastruct ds = {argc-1, copy};

    t1 = pthread_create(&thread1, NULL, (void *) avg_func, (void *) &ds);
    if(t1)
    {
        fprintf(stderr, "Error - pthread_create() returned code: %d\n", t1);
        exit(EXIT_FAILURE);
    }
    t2 = pthread_create(&thread2, NULL, (void *) min_func, (void *) &ds);
    if(t2)
    {
        fprintf(stderr, "Error - pthread_create() returned code: %d\n", t1);
        exit(EXIT_FAILURE);
    }
    t3 = pthread_create(&thread3, NULL, (void *) max_func, (void *) &ds);
    if(t3)
    {
        fprintf(stderr, "Error - pthread_create() returned code: %d\n", t1);
        exit(EXIT_FAILURE);
    }

    printf("pthread_create() for thread 1 returns: %d\n", t1);
    printf("pthread_create() for thread 2 returns: %d\n", t2);
    printf("pthread_create() for thread 3 returns: %d\n", t3);

    pthread_join(thread1, NULL);
    pthread_join(thread2, NULL);
    pthread_join(thread3, NULL);

    printf("The average: %g\n", avg);
    printf("The minimum: %g\n", min);
    printf("The maximum: %g\n", max);

    exit(EXIT_SUCCESS);
}

void *avg_func(void *ptr)
{
    datastruct * copy;
    copy = (datastruct *) ptr;
    int sz = copy -> size;

    for(int i = 0; i < sz; i++)
    {
        avg += (copy -> values[i]);
    }
    avg = (int)(avg/sz);
}

void *min_func(void *ptr)
{
    datastruct * copy;
    copy = (datastruct *) ptr;

    int sz = copy->size;

    min = (copy->values[0]);
    for(int i = 1; i < sz; i++)
    {
        if(min > (copy->values[i]))
        {
            min = (copy->values[i]);
        }
    }
}

void *max_func(void *ptr)
{
    datastruct * copy;
    copy = (datastruct *) ptr;

    int sz = copy->size;

    max = copy->values[0];

    for(int i = 1; i < sz; i++)
    {
        if(max < copy->values[i])
        {
            max = copy->values[i];
        }
    }
}