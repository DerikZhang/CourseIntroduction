package org.tdgo.CourseIntroduction.common;

import java.util.HashMap;
import java.util.Map;

public class APICode {


	public static final Map<String, String> MESSAGE_MAP = new HashMap<String, String>();
	
	public static final String GET_LOWER_LIST_SCORE_OK = "10001";
	public static final String GET_LOWER_LIST_SCORE_ERROR = "10002";

	public static final String GET_HOTTER_LIST_SCORE_OK = "10003";
	public static final String GET_HOTTER_LIST_SCORE_ERROR = "10004";

	public static final String GET_HIGHER_LIST_SCORE_OK = "10005";
	public static final String GET_HIGHER_LIST_SCORE_ERROR = "10006";

	public static final String GET_VAGUE_LIST_OK = "10007";
	public static final String GET_VAGUE_LIST_ERROR = "10008";

	public static final String GET_COMMENT_OK = "10009";
	public static final String GET_COMMENT_ERROR = "10010";
	
	
	static {
		MESSAGE_MAP.put(GET_LOWER_LIST_SCORE_OK, "get lower score list ok");
		MESSAGE_MAP.put(GET_LOWER_LIST_SCORE_ERROR, "get lower score list error");
		MESSAGE_MAP.put(GET_HOTTER_LIST_SCORE_OK, "get hotter score list ok");
		MESSAGE_MAP.put(GET_HOTTER_LIST_SCORE_ERROR, "get hotter score list error");
		MESSAGE_MAP.put(GET_HIGHER_LIST_SCORE_OK, "get higher score list ok");
		MESSAGE_MAP.put(GET_HIGHER_LIST_SCORE_ERROR, "get higher score list error");
		MESSAGE_MAP.put(GET_VAGUE_LIST_OK, "get vague  list ok");
		MESSAGE_MAP.put(GET_VAGUE_LIST_ERROR, "get vague list error");
		MESSAGE_MAP.put(GET_COMMENT_OK, "get comment list ok");
		MESSAGE_MAP.put(GET_COMMENT_ERROR, "get comment list error");
	}
	
}
