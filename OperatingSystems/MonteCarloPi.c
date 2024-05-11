#include<iostream>
#include<pthread.h>
#include<ctime>
#include<cstdlib>

double getRandom(double min=-1,double max=1){
        return min + (rand() * (max - min) / RAND_MAX);
}
int totalPoints=0;
int pointsInCircle=0;

void *countPoints(void *X){
        for(int i=0;i<totalPoints;i++){
                double X=getRandom();
                double Y=getRandom();
                if(X*X+Y*Y <=1)pointsInCircle++;
        }
    return NULL;
}
int main(){
        srand(time(NULL));
        pthread_t thread;
        std::cout<<"Enter Total Points for Experiment :";std::cin>>totalPoints;
        pthread_create(&thread,NULL,&countPoints,NULL);
        pthread_join(thread,NULL);

        double PI=(4.0*pointsInCircle)/totalPoints;
        std::cout<<"Approximate Value For PI for total Points "<<totalPoints<<" is :"<<PI<<"\n";
        return 0;
}