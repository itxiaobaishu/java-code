package com.xiaobai.javacode.jdk8.stream;

import com.xiaobai.javacode.entity.Student;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;
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
     * list 根据字段分组，并对key、value处理
     * @param list
     * @return
     */
    public Map<String, List<Student>> list2mapList(List<Student> list) {
        Map<String, List<Student>> map = list.stream()
                .collect(Collectors.groupingBy(key -> key.getCreateTime().toLocalDate().toString() + " 周一",
                        Collectors.mapping(value -> value, Collectors.toList())));
        return map;
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
//        return list.stream().sorted(Comparator.comparing(Student::getId)).collect(toList());
        //按照两个字段排序
        return list.stream().sorted(Comparator.comparing(Student::getId).thenComparing(Student::getAge)).collect(toList());

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
//        Map<String, List<Integer>> collect = list.stream().collect(groupingBy(Student::getSex, mapping(Student::getAge, toList())));//{女=[Student(id=1, name=1, age=1, sex=女), Student(id=3, name=3, age=3, sex=女)], 男=[Student(id=0, name=0, age=0, sex=男), Student(id=2, name=2, age=2, sex=男), Student(id=4, name=4, age=4, sex=男)]}
        return list.stream().collect(groupingBy(student -> sex.equals(student.getSex()))); //{false=[Student(id=1, name=1, age=1, sex=女), Student(id=3, name=3, age=3, sex=女)], true=[Student(id=0, name=0, age=0, sex=男), Student(id=2, name=2, age=2, sex=男), Student(id=4, name=4, age=4, sex=男)]}
    }

    /**
     * 根据条件把list分组
     *
     * @param list
     * @return
     */
    public Map<Object, List<Integer>> list2group(List<Student> list) {
        return list.stream().collect(groupingBy(Student::getSex, mapping(Student::getAge, toList())));//{女=[1, 3], 男=[0, 2, 4]}
    }

    /**
     * 根据条件把list转map
     *
     * @param list
     * @return
     */
    public Map<Object, Student> list2entityMap(List<Student> list) {
        Map<Object, Student> collect = list.stream().collect(toMap(Student::getSex, Function.identity(), BinaryOperator.maxBy(Comparator.comparing(Student::getAge))));//{女=Student(id=3, name=3, age=3, sex=女, orderId=null), 男=Student(id=4, name=4, age=4, sex=男, orderId=null)}
        return collect;
    }

    /**
     * list转map（key value是实体的两个属性）
     *
     * @param list
     * @return
     */
    public Map<Object, Object> list2entityFieldMap(List<Student> list) {
        Map<Object, Object> collect = list.stream().collect(groupingBy(Student::getSex, collectingAndThen(toList(), s -> s.stream().max(Comparator.comparing(Student::getAge)).get().getAge())));//{女=3, 男=4}
        return collect;
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

    /**
     * 给list的每个元素添加个序号
     *
     * @param list
     * @return
     */
    public List<Student> listAddOrder(List<Student> list) {
        Integer[] arr = {1};
        return list.stream().peek(student -> student.setOrderId(arr[0]++)).collect(toList());
    }

    /**
     * 集合是否存在匹配元素
     *
     * @param list
     * @param matchStr
     * @return
     */
    public boolean match(List<Student> list, String matchStr) {

        //验证是否存在匹配，匹配到第一个即返回true
//        return list.stream().anyMatch(student -> student.getName().startsWith(matchStr));
        //验证是否都匹配，全都匹配返回true
//        return list.stream().allMatch(student -> student.getName().startsWith(matchStr));
        //验证是否都不匹配，全都不匹配返回true
        return list.stream().noneMatch(student -> student.getName().startsWith(matchStr));
    }

    /**
     * 统计总数
     *
     * @param list
     * @param matchStr
     * @return
     */
    public long count(List<Student> list, String matchStr) {
        return list.stream().filter(student -> student.getName().startsWith(matchStr)).count();
    }

    /**
     * 求和
     *
     * @param list
     * @return
     */
    public int sum(List<Student> list) {
        return list.stream().map(Student::getAge).reduce(0, Integer::sum);
    }

    /**
     * 分组后把每组中的最大值组成list
     *
     * @param list
     * @return
     */
    public List<Student> list2List(List<Student> list) {
        System.out.println(list);
        Map<String, Student> collect = list.stream().collect(
                Collectors.groupingBy(Student::getSex,
                        Collectors.collectingAndThen(Collectors.reducing((c1, c2) -> c1.getAge().intValue() > c2.getAge().intValue() ? c1 : c2),
                                Optional::get)));
        list = new ArrayList<>(collect.values());

        return list;
    }

}
