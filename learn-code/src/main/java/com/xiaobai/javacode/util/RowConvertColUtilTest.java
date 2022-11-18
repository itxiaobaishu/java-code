package com.xiaobai.javacode.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaobai
 * @Description: RowConvertColUtil测试类
 * @date 2021/11/1811:52 上午
 */
public class RowConvertColUtilTest {
    private static class ScoreInfo {
        private Integer id;
        private String stuName;
        private String subjectName;
        private Integer value;

        public String getStuName() {
            return stuName;
        }

        public String getSubjectName() {
            return subjectName;
        }

        public Integer getValue() {
            return value;
        }

        public ScoreInfo(String stuName, String subjectName, Integer value) {
            this.stuName = stuName;
            this.subjectName = subjectName;
            this.value = value;
        }

        public ScoreInfo(Integer id, String stuName, String subjectName, Integer value) {
            this.id = id;
            this.stuName = stuName;
            this.subjectName = subjectName;
            this.value = value;
        }

        @Override
        public String toString() {
            return "ScoreInfo{" +
                    "id=" + id +
                    ", stuName='" + stuName + '\'' +
                    ", subjectName='" + subjectName + '\'' +
                    ", value=" + value +
                    '}';
        }
    }

    public static void main(String[] args) throws Exception {
        func2();
    }

    private static void func2() throws Exception {
        List<ScoreInfo> scoreInfoList = new ArrayList<>();
        scoreInfoList.add(new ScoreInfo(1,"张三", "语文", 61));
        scoreInfoList.add(new ScoreInfo(2,"张三", "数学", 78));
        scoreInfoList.add(new ScoreInfo(3,"张三", "英语", 93));
        scoreInfoList.add(new ScoreInfo(4,"李四", "语文", 70));
        scoreInfoList.add(new ScoreInfo(5,"李四", "数学", 86));
        scoreInfoList.add(new ScoreInfo(6,"李四", "英语", 72));
        scoreInfoList.add(new ScoreInfo(7,"王五", "语文", 66));
        scoreInfoList.add(new ScoreInfo(8,"赵六", "语文", 91));
        scoreInfoList.add(new ScoreInfo(9,"王五", "数学", 88));
        scoreInfoList.add(new ScoreInfo(10,"赵六", "数学", 63));
        scoreInfoList.add(new ScoreInfo(11,"王五", "英语", 93));
        scoreInfoList.add(new ScoreInfo(12,"赵六", "英语", 58));
        scoreInfoList.add(new ScoreInfo(13,"王七", "英语", 65));
        scoreInfoList.add(new ScoreInfo(14,"王七", "数学", 91));
        for (ScoreInfo scoreInfo : scoreInfoList) {
            System.out.println(scoreInfo.toString());
        }

        System.out.println("-------------------");

        List<List<Object>> lists = RowConvertColUtil.doConvert(scoreInfoList, "subjectName", "stuName", "value", true);

        for (List<Object> list : lists) {
            System.out.println(list.toString());
        }

        System.out.println("-------------------");

        RowConvertColUtil.ConvertData convertData = RowConvertColUtil.doConvertReturnObj(scoreInfoList, "subjectName", "stuName", "value", true);
        System.out.println(convertData);

        //测试结果
        /**
         * ScoreInfo{stuName='张三', subjectName='语文', value=61}
         * ScoreInfo{stuName='张三', subjectName='数学', value=78}
         * ScoreInfo{stuName='张三', subjectName='英语', value=93}
         * ScoreInfo{stuName='李四', subjectName='语文', value=70}
         * ScoreInfo{stuName='李四', subjectName='数学', value=86}
         * ScoreInfo{stuName='李四', subjectName='英语', value=72}
         * ScoreInfo{stuName='王五', subjectName='语文', value=66}
         * ScoreInfo{stuName='赵六', subjectName='语文', value=91}
         * ScoreInfo{stuName='王五', subjectName='数学', value=88}
         * ScoreInfo{stuName='赵六', subjectName='数学', value=63}
         * ScoreInfo{stuName='王五', subjectName='英语', value=93}
         * ScoreInfo{stuName='赵六', subjectName='英语', value=58}
         * ScoreInfo{stuName='王七', subjectName='英语', value=65}
         * ScoreInfo{stuName='王七', subjectName='数学', value=91}
         * -------------------
         * [, 语文, 数学, 英语]
         * [张三, 61, 78, 93]
         * [李四, 70, 86, 72]
         * [王五, 66, 88, 93]
         * [赵六, 91, 63, 58]
         * [王七, , 91, 65]
         * -------------------
         * ConvertData{headerSet=[语文, 数学, 英语], firstColSet=[张三, 李四, 王五, 赵六, 王七], dataList=[[, 语文, 数学, 英语], [张三, 61, 78, 93], [李四, 70, 86, 72], [王五, 66, 88, 93], [赵六, 91, 63, 58], [王七, , 91, 65]]}
         *
         */
    }
}

