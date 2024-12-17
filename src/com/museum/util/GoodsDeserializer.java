package com.museum.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.museum.bean.Goods;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GoodsDeserializer extends JsonDeserializer<Goods> {

	@Override
	public Goods deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		String goodsString = p.getText();

		// 假设你的字符串格式是类似： "Goods{id=1, name='商品1', price=10.0, stock=999, image='null'}"
		// 使用正则表达式提取各个字段的值
		Pattern pattern = Pattern.compile(
				"Goods\\{id=(\\d+), name='([^']*)', price=(\\d*\\.\\d+|\\d+), stock=(\\d+), image='([^']*)'\\}");
		Matcher matcher = pattern.matcher(goodsString);

		Goods goods = new Goods();

		if (matcher.find()) {
			goods.setId(Integer.parseInt(matcher.group(1))); // 提取 id
			goods.setName(matcher.group(2));                 // 提取 name
			goods.setPrice(Double.parseDouble(matcher.group(3))); // 提取 price
			goods.setStock(Integer.parseInt(matcher.group(4)));   // 提取 stock
			goods.setImage(matcher.group(5));               // 提取 image
		} else {
			throw new IOException("无法解析 Goods 字符串: " + goodsString);
		}

		return goods;
	}
}
