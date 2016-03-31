package com.app.server.businessservice.defaultcontext.defaultdomain;
import com.app.server.businessservice.defaultcontext.FQBzService;
import com.app.server.repository.defaultcontext.defaultdomain.TestARepository;
import com.app.shared.defaultcontext.defaultdomain.TestA;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.shared.defaultcontext.defaultdomain.NewDto;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@Component
public class FNew {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private TestARepository<TestA> testARepository;

    @Autowired
    private FQBzService fQBzService;

    public void proFNew(NewDto dt) throws SpartanPersistenceException, SpartanConstraintViolationException, Exception {
        java.util.List<com.app.shared.defaultcontext.FQ> fQList = fQBzService.executeQueryFQ(dt.gettNm());
        for (com.app.shared.defaultcontext.FQ fQListElement1 : fQList) {
            com.app.shared.defaultcontext.defaultdomain.TestA testA = new com.app.shared.defaultcontext.defaultdomain.TestA();
            testA.setFrndNm(fQListElement1.getFrndNm());
            testA.settNm(dt.gettNm());
            com.app.shared.defaultcontext.defaultdomain.TestA testA1 = testARepository.save(testA);
        }
    }
}
