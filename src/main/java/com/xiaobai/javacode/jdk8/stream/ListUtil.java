package com.xiaobai.javacode.jdk8.stream;

import com.xiaobai.javacode.entity.Student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * @author xiaobai
 * @description: 列举jdk8中stream(并发使用parallelStream)操作list的方法 所有方法只是列举了一种形式，根据自己的需求举一反三吧
 * @date 2020/1/14 11:58 上午
 */
public class ListUtil {

    /**
     * list根据对象的某个属性去重
     *
     * @param list 去重前的list
     * @return 去重后的list
     */
    public List<Student> repeat(List<Student> list) {
        //方法一
        return list.stream().distinct().collect(toList());
        //方法二
//        return list.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Student::getId))), ArrayList::new));
    }

    /**
     * list转map
     *
     * @param list
     * @return
     */
    public Map<String, Student> list2map(List<Student> list) {
        return list.stream().collect(Collectors.toMap(Student::getId, student -> student));
    }

    /**
     * 从list过滤出符合条件的数据
     *
     * @param list
     * @param id   过滤的条件
     * @return
     */
    public List<Student> filter(List<Student> list, String id) {
        return list.stream().filter(student -> id.equals(student.getId())).collect(toList());
    }

    /**
     * 从list过滤出符合条件的数据 写法一
     *
     * @param list
     * @param id
     * @param age
     * @return
     */
    public List<Student> filter(List<Student> list, String id, Integer age) {
        return list.stream().filter(student -> id.equals(student.getId()) && student.getAge() < age).collect(toList());
    }

    /**
     * 从list过滤出符合条件的数据 写法二
     *
     * @param list
     * @param id
     * @param name
     * @return
     */
    public List<Student> filter(List<Student> list, String id, String name) {
        return list.stream().filter(student -> {
            if (id.equals(student.getId()) && name.equals(student.getName())) {
                return true;
            }
            return false;
        }).collect(toList());
    }

    /**
     * list根据指定条件排序
     *
     * @param list
     * @return
     */
    public List<Student> sort(List<Student> list) {
        //倒序
//        return list.stream().sorted(Comparator.comparing(Student::getId).reversed()).collect(Collectors.toList());
        //升序
        return list.stream().sorted(Comparator.comparing(Student::getId)).collect(toList());
    }

    /**
     * 把list的对象中属性重新拼接成list
     *
     * @param list
     * @return
     */
    public List<String> list2list(List<Student> list) {
        //写法一
//        return list.stream().map(student -> student.getId()).collect(toList());
        //写法二
        return list.stream().map(Student::getId).collect(toList());
        //写法三
//        return list.stream().map(student -> {
//            return student.getId();
//        }).collect(toList());
    }

    /**
     * 把list的对象中属性重新拼接成set
     *
     * @param list
     * @return
     */
    public Set<String> list2Set(List<Student> list) {
        //写法一
        return list.stream().map(student -> student.getId()).collect(toSet());
        //写法二
//        return list.stream().map(Student::getId).collect(toSet());
        //写法三
//        return list.stream().map(student -> {
//            return student.getId();
//        }).collect(toSet());
    }

    /**
     * 把list的对象中属性重新拼接成 指定类型
     *
     * @param list
     * @return
     */
    public TreeSet<String> list2TreeSet(List<Student> list) {
        //写法一
        return list.stream().map(student -> student.getId()).collect(toCollection(TreeSet::new));
        //写法二
//        return list.stream().map(Student::getId).collect(toCollection(TreeSet::new));
        //写法三
//        return list.stream().map(student -> {
//            return student.getId();
//        }).collect(toCollection(TreeSet::new));
    }

    /**
     * 根据条件把list分组
     *
     * @param list
     * @param sex
     * @return
     */
    public Map<Object, List<Student>> list2group(List<Student> list, String sex) {
//        return list.stream().collect(groupingBy(Student::getSex)); //{女=[Student(id=1, name=1, age=1, sex=女), Student(id=3, name=3, age=3, sex=女)], 男=[Student(id=0, name=0, age=0, sex=男), Student(id=2, name=2, age=2, sex=男), Student(id=4, name=4, age=4, sex=男)]}
        return list.stream().collect(groupingBy(student -> sex.equals(student.getSex()))); //{false=[Student(id=1, name=1, age=1, sex=女), Student(id=3, name=3, age=3, sex=女)], true=[Student(id=0, name=0, age=0, sex=男), Student(id=2, name=2, age=2, sex=男), Student(id=4, name=4, age=4, sex=男)]}
    }

    /**
     * 把list中的元素用指定的字符分隔及前后缀
     *
     * @param list
     * @return
     */
    public String list2joining(List<Student> list) {
        return list.stream().map(student -> student.getId()).collect(joining(",", "{", "}"));
    }

    public List reduce() {
        return Stream.of("1", "2", "3", "4").collect(reducing(new ArrayList(), x -> Arrays.asList(x), (y, z) -> {
            y.addAll(z);
            return y;
        }));
    }

    /**
     * 把list拼接成字符串
     *
     * @param list
     * @return
     */
    public String joinStr(List<Student> list) {
        StringBuilder sb = new StringBuilder();
        list.forEach(sb::append);
        return sb.toString();
    }


}
