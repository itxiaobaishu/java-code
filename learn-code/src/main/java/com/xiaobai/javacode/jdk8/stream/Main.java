package com.xiaobai.javacode.jdk8.stream;

import com.xiaobai.javacode.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author xiaobai
 * @description: Stream测试类
 * @date 2020/1/14 11:56 上午
 */
public class Main {

    public static void main(String[] args) {

        ListUtil lambda = new ListUtil();
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Student student = Student.builder().id(String.valueOf(i)).name(String.valueOf(i)).age(i).build();
            if (i % 2 == 0) {
                student.setSex("男");
            } else {
                student.setSex("女");
            }
            list.add(student);
        }

        /**
         * 测试去重
         */
        //添加一条重复数据
//        list.add(Student.builder().id("0").name("0").age(0).build());
//        System.out.println(list);
//        List<Student> repeat = lambda.repeat(list);
//        System.out.println(repeat);

        /**
         * 测试list转map
         */
//        Map<String, Student> stringStudentMap = lambda.list2map(list);
//        System.out.println(stringStudentMap);

        /**
         * 测试list转list
         */
//        List<String> strings = lambda.list2list(list);
//        System.out.println(strings);

        /**
         * 测试list过滤
         */
//        List<Student> filter = lambda.filter(list, "1");
//        System.out.println(filter);

        /**
         * 测试排序
         */
//        List<Student> sort = lambda.sort(list);
//        System.out.println(sort);

        /**
         * 测试list拼接成字符串
         */
//        String joinStr = lambda.joinStr(list);
//        System.out.println(joinStr);

        /**
         * 测试 reduce
         */
//        Integer reduce = Stream.of(1, 2, 3, 4).reduce(0, (x, y) -> x + y);
//        System.out.println(reduce);
//        String reduce1 = Stream.of("1", "2", "3", "4").reduce("0", (x, y) -> (x + "," + y));
//        System.out.println(reduce1);

        /**
         * 测试reducing
         */
//        List reduce = lambda.reduce();
//        System.out.println(reduce);


        /**
         * 测试分组
         */
//        Map<Object, List<Student>> objectListMap = lambda.list2group(list, "男");
//        System.out.println(objectListMap);

        /**
         * 测试分隔
         */
//        String joining = lambda.list2joining(list);
//        System.out.println(joining);


        /**
         * 测试list添加序号
         */
        //List<Student> students = lambda.listAddOrder(list);
        //System.out.println(students);

        /**
         * 测试求和
         */
        //int sum = lambda.sum(list);
        //System.out.println(sum);

        /**
         * 测试分组
         */
        //Map<Object, List<Integer>> objectListMap = lambda.list2group(list);
        //System.out.println(objectListMap);

        Map<Object, Student> objectStudentMap = lambda.list2entityMap(list);
        System.out.println(objectStudentMap);

        Map<Object, Object> objectObjectMap = lambda.list2entityFieldMap(list);
        System.out.println(objectObjectMap);

    }
}
