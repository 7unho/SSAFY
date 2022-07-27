package com.ssafy.lambda;

@FunctionalInterface
public interface You {
    void run();


//    void walk(); => 이미 run()이 있기 때문에, FunctionalInterface에 위배됨 !
}
