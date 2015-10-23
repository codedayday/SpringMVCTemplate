package com.dayday.action;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class LocationInfoTest extends JUnitActionBase {

    /**
     * TODO: write description for this method.
     */
/*    @Test
    public void testKeepAlive() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ACTION", "KEEP_ALIVE");
        this.excuteAction("/IBEFacade", 8080, paramMap);
    }*/

    /**
     * TODO: write description for this method.
     */
    @Test
    public void testLocationInfo() {
        ModelAndView model = this.excuteAction("/index", 8080, new Object[]{"ACTION", "LOCATION_INFO"});
        System.out.println(model.getViewName());
    }
}