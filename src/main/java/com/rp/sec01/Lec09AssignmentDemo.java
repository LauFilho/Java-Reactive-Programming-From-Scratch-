package com.rp.sec01;

import com.rp.courseutil.Util;
import com.rp.sec01.Tarefa1.FileService.FileServiceImpl;

public class Lec09AssignmentDemo {


    public static void main(String[] args) {
        FileServiceImpl.readMono("file01.txt")
                .subscribe(s ->
                                Util.onNext(),
                        Util.onError(),
                        Util.onComplete());
    }


}
