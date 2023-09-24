package com.geekaca.stc;

import com.geekaca.stc.domain.Class;
import com.geekaca.stc.mapper.ClassMapper;
import com.geekaca.stc.mapper.StuMapper;
import com.geekaca.stc.mapper.SubjectsMapper;
import com.geekaca.stc.mapper.TestMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@SpringBootTest
@Transactional
class StudentTestScoresApplicationTests {

    @Autowired
    private ClassMapper cm;
    @Autowired
    private StuMapper sm;
    @Autowired
    private SubjectsMapper sjm;
    @Autowired
    private TestMapper tm;

    @Test
    public void testGetMembers(){
        List<Class> classes = cm.selectClassMembers();
        System.out.println("内容:"+classes);
    }

    @Test
    public void testGetTestAndSub(){
        List<com.geekaca.stc.domain.Test> scoresOfStu = tm.getScoresOfStu(2000102l);
        System.out.println(scoresOfStu);
    }
}
