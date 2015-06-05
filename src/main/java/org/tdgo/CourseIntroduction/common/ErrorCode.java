package org.tdgo.CourseIntroduction.common;

import java.util.HashMap;
import java.util.Map;

public class ErrorCode {
	
	public static final Map<String, String> MESSAGE_MAP = new HashMap<String, String>();
	
	//Academy Dao Code
	public static final String ADD_ACADEMY_OK = "50001";
	public static final String ADD_ACADEMY_ERROR = "50002";
	public static final String UPDATE_ACADEMY_OK = "50003";
	public static final String UPDATE_ACADEMY_ERROR = "50004";
	public static final String DELETE_ACADEMY_OK = "50005";
	public static final String DELETE_ACADEMY_ERROR = "50006";
	public static final String GET_ACADEMY_BY_AID_OK = "50007";
	public static final String GET_ACADEMY_BY_AID_ERROR = "50008";
	public static final String GET_ACADEMY_BY_NAME_OK = "50009";
	public static final String GET_ACADEMY_BY_NAME_ERROR = "50010";
	//Lesson Dao Code
	public static final String ADD_LESSON_OK = "50011";
	public static final String ADD_LESSON_ERROR = "50012";
	public static final String UPDATE_LESSON_OK = "50013";
	public static final String UPDATE_LESSON_ERROR = "50014";
	public static final String DELETE_LESSON_OK = "50015";
	public static final String DELETE_LESSON_ERROR = "50016";
	public static final String GET_LESSON_BY_LID_OK = "50017";
	public static final String GET_LESSON_BY_LID_ERROR = "50018";
	public static final String GET_LESSON_BY_TID_OK = "50019";
	public static final String GET_LESSON_BY_TID_ERROR = "50020";
	public static final String GET_LESSON_BY_AID_OK = "50021";
	public static final String GET_LESSON_BY_AID_ERROR = "50022";
	public static final String GET_LESSON_BY_PROPERTY_OK = "50023";
	public static final String GET_LESSON_BY_PROPERTY_ERROR = "50024";
	public static final String GET_LESSON_BY_NAME_OK = "50025";
	public static final String GET_LESSON_BY_NAME_ERROR = "50026";
	public static final String GET_LESSON_BY_SEARCH_SCORE_OK = "50027";
	public static final String GET_LESSON_BY_SEARCH_SCORE_ERROR = "50028";
	public static final String GET_LESSON_BY_SEARCH_COMMENT_OK = "50029";
	public static final String GET_LESSON_BY_SEARCH_COMMENT_ERROR = "50030";
	public static final String GET_LESSON_BY_VAGUE_OK = "50031";
	public static final String GET_LESSON_BY_VAGUE_ERROR = "50032";
	//Comment Dao Code
	public static final String ADD_COMMENT_OK = "50033";
	public static final String ADD_COMMENT_ERROR = "50034";
	public static final String DELETE_COMMENT_OK = "50035";
	public static final String DELETE_COMMENT_ERROR = "50036";
	public static final String GET_COMMENT_BY_CID_OK = "50037";
	public static final String GET_COMMENT_BY_CID_ERROR = "50038";
	public static final String GET_COMMENT_BY_LID_OK = "50039";
	public static final String GET_COMMENT_BY_LID_ERROR = "50040";
	public static final String GET_COMMENT_BY_TID_OK = "50041";
	public static final String GET_COMMENT_BY_TID_ERROR = "50042";
	public static final String GET_COMMENT_BY_NAME_OK = "50043";
	public static final String GET_COMMENT_BY_NAME_ERROR = "50044";
	public static final String GET_COMMENT_BY_WRITE_TIME_OK = "50045";
	public static final String GET_COMMENT_BY_WRITE_TIME_ERROR = "50046";
	public static final String UPDATE_COMMENT_OK = "50047";
	public static final String UPDATE_COMMENT_ERROR = "50048";
	//Teacher Dao Code
	public static final String GET_TEACHER_BY_AID_OK = "50049";
	public static final String GET_TEACHER_BY_AID_ERROR = "50050";
	public static final String GET_TEACHER_BY_NAME_OK = "50051";
	public static final String GET_TEACHER_BY_NAME_ERROR = "50052";
	public static final String ADD_TEACHER_OK = "50053";
	public static final String ADD_TEACHER_ERROR = "50054";
	public static final String UPDATE_TEACHER_OK = "50055";
	public static final String UPDATE_TEACHER_ERROR = "50056";
	public static final String DELETE_TEACHER_OK = "50057";
	public static final String DELETE_TEACHER_ERROR = "50058";
	public static final String GET_TEACHER_BY_TID_OK = "50059";
	public static final String GET_TEACHER_BY_TID_ERROR = "50060";
	//OperaterDao
	public static final String GET_OPERATER_BY_USERNAME_OK = "50061";
	public static final String GET_OPERATER_BY_USERNAME_ERROR = "50062";
	//Common
	public static final String USERNAME_NOT_EXIST = "20002";
	public static final String TEACHER_ID_NULL = "20004";
	public static final String LESSON_ID_NULL = "20006";
	public static final String SCORE_ID_NULL = "20008";
	//OperaterService
	public static final String LOGIN_IN_SERVICE_OK = "30001";
	public static final String LOGIN_IN_SERVICE_PASSWORD_WRONG = "30002";
	//CommentService
	public static final String GOOD_COMMENT_OK = "30003";
	public static final String GOOD_COMMENT_ERROR = "30004";
	public static final String COMMENT_LESSON_OK = "30005";
	public static final String COMMENT_LESSON_ERROR = "30006";
	public static final String GET_COMMENT_INFO_OK = "30007";
	public static final String GET_COMMENT_INFO_ERROR = "30008";
	//SearchService
	public static final String GET_SCORE_LESSON_OK = "30009";
	public static final String GET_SCORE_LESSON_ERROR = "30010";
	public static final String GET_COMMENT_LESSON_OK = "30011";
	public static final String GET_COMMENT_LESSON_ERROR = "30012";
	public static final String GET_VAGUE_LESSON_OK = "30013";
	public static final String GET_VAGUE_LESSON_ERROR = "30014";
	//LessonService
	public static final String GET_LESSONBO_INFO_OK = "30015";
	public static final String GET_LESSONBO_INFO_ERROR = "30016";
	public static final String GET_LESSONBO_BY_ID_OK = "30017";
	public static final String GET_LESSONBO_BY_ID_ERROR = "30018";
	public static final String GET_LESSON_BY£ßSTATUS_OK = "30019";
	public static final String GET_LESSON_BY£ßSTATUS_ERROR = "30020";

	public static final String GET_LESSONBO_FOR£ßHOME_OK = "30021";
	public static final String GET_LESSONBO_FOR£ßHOME_ERROR = "30022";


	
	
	static{
		//Academy Dao
		MESSAGE_MAP.put(ADD_ACADEMY_OK, "add academy in dao OK");
		MESSAGE_MAP.put(ADD_ACADEMY_ERROR, "add academy in dao error");
		MESSAGE_MAP.put(UPDATE_ACADEMY_OK, "update academy in dao OK");
		MESSAGE_MAP.put(UPDATE_ACADEMY_ERROR, "update academy in dao error");
		MESSAGE_MAP.put(DELETE_ACADEMY_OK, "delete academy in dao OK");
		MESSAGE_MAP.put(DELETE_ACADEMY_ERROR, "delete academy in dao error");
		MESSAGE_MAP.put(GET_ACADEMY_BY_AID_OK, "get academy by AID in dao OK");
		MESSAGE_MAP.put(GET_ACADEMY_BY_AID_ERROR, "get academy by AID in dao error");
		MESSAGE_MAP.put(GET_ACADEMY_BY_NAME_OK, "get academy by name in dao OK");
		MESSAGE_MAP.put(GET_ACADEMY_BY_NAME_ERROR, "get academy by name in dao error");
		//Lesson Dao
		MESSAGE_MAP.put(ADD_LESSON_OK, "add lesson in dao OK");
		MESSAGE_MAP.put(ADD_LESSON_ERROR, "add lesson in dao error");
		MESSAGE_MAP.put(UPDATE_LESSON_OK, "update lesson in dao OK");
		MESSAGE_MAP.put(UPDATE_LESSON_ERROR, "update lesson in dao error");
		MESSAGE_MAP.put(DELETE_LESSON_OK, "delete lesson in dao OK");
		MESSAGE_MAP.put(DELETE_LESSON_ERROR, "delete lesson in dao error");
		MESSAGE_MAP.put(GET_LESSON_BY_LID_OK, "get lesson by LID in dao OK");
		MESSAGE_MAP.put(GET_LESSON_BY_LID_ERROR, "get lesson by LID in dao error");
		MESSAGE_MAP.put(GET_LESSON_BY_TID_OK, "get lesson by TID in dao OK");
		MESSAGE_MAP.put(GET_LESSON_BY_TID_ERROR, "get lesson by TID in dao error");
		MESSAGE_MAP.put(GET_LESSON_BY_AID_OK, "get lesson by AID in dao OK");
		MESSAGE_MAP.put(GET_LESSON_BY_AID_ERROR, "get lesson by AID in dao error");
		MESSAGE_MAP.put(GET_LESSON_BY_PROPERTY_OK, "get lesson by property in dao OK");
		MESSAGE_MAP.put(GET_LESSON_BY_PROPERTY_ERROR, "get lesson by property in dao error");
		MESSAGE_MAP.put(GET_LESSON_BY_NAME_OK, "get lesson by name in dao OK");
		MESSAGE_MAP.put(GET_LESSON_BY_NAME_ERROR, "get lesson by name in dao error");
		MESSAGE_MAP.put(GET_LESSON_BY_SEARCH_SCORE_OK, "get lesson by search score in dao OK");
		MESSAGE_MAP.put(GET_LESSON_BY_SEARCH_SCORE_ERROR, "get lesson by search score in dao error");
		MESSAGE_MAP.put(GET_LESSON_BY_SEARCH_COMMENT_OK, "get lesson by search comment in dao OK");
		MESSAGE_MAP.put(GET_LESSON_BY_SEARCH_COMMENT_ERROR, "get lesson by search comment in dao error");
		MESSAGE_MAP.put(GET_LESSON_BY_VAGUE_OK, "get lesson by vague in dao ok");
		MESSAGE_MAP.put(GET_LESSON_BY_VAGUE_ERROR, "get lesson by vague in dao error");
		MESSAGE_MAP.put(GET_LESSON_BY£ßSTATUS_OK, "get lesson by status in dao ok");
		MESSAGE_MAP.put(GET_LESSON_BY£ßSTATUS_ERROR, "get lesson by status in dao error");
		//Comment Dao
		MESSAGE_MAP.put(ADD_COMMENT_OK, "add comment in dao OK");
		MESSAGE_MAP.put(ADD_COMMENT_ERROR, "add comment in dao error");
		MESSAGE_MAP.put(DELETE_COMMENT_OK, "delete comment in dao OK");
		MESSAGE_MAP.put(DELETE_COMMENT_ERROR, "delete comment in dao error");
		MESSAGE_MAP.put(UPDATE_COMMENT_OK, "update comment in dao OK");
		MESSAGE_MAP.put(UPDATE_COMMENT_ERROR, "update comment in dao error");
		MESSAGE_MAP.put(GET_COMMENT_BY_CID_OK, "get comment by CID in dao OK");
		MESSAGE_MAP.put(GET_COMMENT_BY_CID_ERROR, "get comment by CID in dao error");
		MESSAGE_MAP.put(GET_COMMENT_BY_TID_OK, "get comment by TID in dao OK");
		MESSAGE_MAP.put(GET_COMMENT_BY_TID_ERROR, "get comment by TID in dao error");
		MESSAGE_MAP.put(GET_COMMENT_BY_NAME_OK, "get comment by name in dao OK");
		MESSAGE_MAP.put(GET_COMMENT_BY_NAME_ERROR, "get comment by name in dao error");
		MESSAGE_MAP.put(GET_COMMENT_BY_WRITE_TIME_OK, "get comment by write time in dao OK");
		MESSAGE_MAP.put(GET_COMMENT_BY_WRITE_TIME_ERROR, "get comment by write time in dao error");
		//Teacher Dao
		MESSAGE_MAP.put(ADD_TEACHER_OK, "add teacher in dao OK");
		MESSAGE_MAP.put(ADD_TEACHER_ERROR, "add teacher in dao error");
		MESSAGE_MAP.put(UPDATE_TEACHER_OK, "update teacher in dao OK");
		MESSAGE_MAP.put(UPDATE_TEACHER_ERROR, "update teacher in dao error");
		MESSAGE_MAP.put(DELETE_TEACHER_OK, "delete teacher in dao OK");
		MESSAGE_MAP.put(DELETE_TEACHER_ERROR, "delete teacher in dao error");
		MESSAGE_MAP.put(GET_TEACHER_BY_TID_OK, "get teacher by TID in dao OK");
		MESSAGE_MAP.put(GET_TEACHER_BY_TID_ERROR, "get teacher by TID in dao error");
		MESSAGE_MAP.put(GET_TEACHER_BY_AID_OK, "get teacher by AID in dao OK");
		MESSAGE_MAP.put(GET_TEACHER_BY_AID_ERROR, "get teacher by AID in dao error");
		MESSAGE_MAP.put(GET_TEACHER_BY_NAME_OK, "get teacher by name in dao OK");
		MESSAGE_MAP.put(GET_TEACHER_BY_NAME_ERROR, "get teacher by name in dao error");
		//OperaterDao
		MESSAGE_MAP.put(GET_OPERATER_BY_USERNAME_OK, "get operater by username in dao OK");
		MESSAGE_MAP.put(GET_OPERATER_BY_USERNAME_ERROR, "get operater by username in dao error");
		//OperaterService
		MESSAGE_MAP.put(LOGIN_IN_SERVICE_OK, "login success in service");
		MESSAGE_MAP.put(LOGIN_IN_SERVICE_PASSWORD_WRONG, "password wrong in login service");
		//Common
		MESSAGE_MAP.put(USERNAME_NOT_EXIST, "username didn't exist!");
		MESSAGE_MAP.put(TEACHER_ID_NULL, "teacher id can not be null!");
		MESSAGE_MAP.put(LESSON_ID_NULL, "lesson id can not be null!");
		MESSAGE_MAP.put(SCORE_ID_NULL, "score id can not be null!");
		//CommentService
		MESSAGE_MAP.put(COMMENT_LESSON_OK, "comment lesson in service ok");
		MESSAGE_MAP.put(COMMENT_LESSON_ERROR, "comment lesson in service error");
		MESSAGE_MAP.put(GOOD_COMMENT_OK, "good comment in service ok");
		MESSAGE_MAP.put(GOOD_COMMENT_ERROR, "good comment in service error");
		MESSAGE_MAP.put(GET_COMMENT_INFO_OK, "get comment bo Info in service ok");
		MESSAGE_MAP.put(GET_COMMENT_INFO_ERROR, "get comment bo info in service error");
		//SearchService
		MESSAGE_MAP.put(GET_SCORE_LESSON_OK, "get score lesson in service ok");
		MESSAGE_MAP.put(GET_SCORE_LESSON_ERROR, "get score lesson in service error");
		MESSAGE_MAP.put(GET_COMMENT_LESSON_OK, "get comment lesson in service ok");
		MESSAGE_MAP.put(GET_COMMENT_LESSON_ERROR, "get comment lesson in service error");
		MESSAGE_MAP.put(GET_VAGUE_LESSON_OK, "get vague lesson in service ok");
		MESSAGE_MAP.put(GET_VAGUE_LESSON_ERROR, "get vague lesson in service error");
		//LessonService
		MESSAGE_MAP.put(GET_LESSONBO_INFO_OK, "get lessonBo information in service ok");
		MESSAGE_MAP.put(GET_LESSONBO_INFO_ERROR, "get lessonBo information in service error");
		MESSAGE_MAP.put(GET_LESSONBO_BY_ID_OK, "get lessonBo information by id in service ok");
		MESSAGE_MAP.put(GET_LESSONBO_BY_ID_ERROR, "get lessonBo information by id in service error");
		MESSAGE_MAP.put(GET_LESSONBO_FOR£ßHOME_OK, "get lessonBo for home page in service ok");
		MESSAGE_MAP.put(GET_LESSONBO_FOR£ßHOME_ERROR, "get lessonBo for home page in service error");
		
	}
}
