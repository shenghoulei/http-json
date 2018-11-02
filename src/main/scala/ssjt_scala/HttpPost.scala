package ssjt_scala

import com.google.gson.{JsonObject, JsonParser}
import scalaj.http.Http

/**
  * @Author: shy
  * @Date: 2018/11/2 10:18
  * @Description:
  */
object HttpPost {
	def main(args: Array[String]): Unit = {
		//http get请求 设置超时时间
		val request = "http://apis.juhe.cn/mobile/get?phone=18801013495&dtype=&key=700db8c9b991d05cc206344d35414e90"
		val response = Http(request)
				.timeout(connTimeoutMs = 2000, readTimeoutMs = 5000)
				.asString
		val body = response.body
		val json = new JsonParser()
		val obj = json.parse(body).asInstanceOf[JsonObject]
		println(obj.get("result"))
	}

}
