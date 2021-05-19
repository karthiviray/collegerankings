package com.ayan.collegeDAO;

import java.util.List;
import com.ayan.model.College;

public interface CollegeDAO {
	
	//CURD operation
		public int insertCollege(College C);
		public List<College> getAllCollege();
		public College getCollegeById(String contact_email);
		public int updateCollege(College C);
		public int deleteCollege(String contact_email);

}
