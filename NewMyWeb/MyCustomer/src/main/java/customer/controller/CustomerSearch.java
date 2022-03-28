package customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import customer.dao.CustomerDao;
import customer.vo.CustomerVO;
import custormer.biz.CustomerBiz;

@Controller
public class CustomerSearch {
	@Autowired
	private CustomerBiz biz;
	
	

	@RequestMapping("/customerSearch.do")
	public ModelAndView search(@RequestParam("id") String id){
		//  String id= request.getPramameter("id");		
		CustomerVO vo1 = biz.searchCustomer(id);
		ModelAndView mav=new ModelAndView("customer/view","vo",vo1);
		return mav;
	}
}





