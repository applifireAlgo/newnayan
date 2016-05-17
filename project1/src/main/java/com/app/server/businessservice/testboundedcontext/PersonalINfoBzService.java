package com.app.server.businessservice.testboundedcontext;
import com.app.shared.testboundedcontext.PersonalINfo;
import java.util.List;

public interface PersonalINfoBzService {

    public List<PersonalINfo> executeQueryPersonalINfo() throws Exception;
}
