package com.museum.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.museum.bean.User;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserDeserializer extends JsonDeserializer<User> {

	@Override
	public User deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		String userString = p.getText();

		// 假设你的字符串格式是类似： "User{id=2, username='lht', avatar='null', password='123456', name='李浩天', email='1175779914@qq.com', phone='13058696369', address='地址', isAdmin=true, isValidate=true}"
		// 使用正则表达式提取各个字段的值
		Pattern pattern = Pattern.compile(
				"User\\{id=(\\d+), username='([^']*)', avatar='([^']*)', password='([^']*)', name='([^']*)', email='([^']*)', phone='([^']*)', address='([^']*)', isAdmin=(true|false), isValidate=(true|false)\\}");
		Matcher matcher = pattern.matcher(userString);

		User user = new User();

		if (matcher.find()) {
			user.setId(Integer.parseInt(matcher.group(1))); // 提取 id
			user.setUsername(matcher.group(2));            // 提取 username
			user.setAvatar(matcher.group(3));              // 提取 avatar
			user.setPassword(matcher.group(4));            // 提取 password
			user.setName(matcher.group(5));                // 提取 name
			user.setEmail(matcher.group(6));               // 提取 email
			user.setPhone(matcher.group(7));               // 提取 phone
			user.setAddress(matcher.group(8));             // 提取 address
			user.setIsAdmin(Boolean.parseBoolean(matcher.group(9))); // 提取 isAdmin
			user.setIsValidate(Boolean.parseBoolean(matcher.group(10))); // 提取 isValidate
		} else {
			throw new IOException("无法解析 User 字符串: " + userString);
		}

		return user;
	}
}

