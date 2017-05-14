package com.andrew.bystrov.translate.jsons;

import com.intellij.openapi.diagnostic.Logger;

public class JsonUtils
{
	public static Exception createException(int code, String initMsg)
	{
		Logger.getInstance(JsonUtils.class).debug("Json exception");
		Logger.getInstance(JsonUtils.class).debug(initMsg);
		String message = null;
		switch (code)
		{
			case 401:
				message = "Invalid API-key. Change it on settings and try again";
				break;

			case 402:
				message = "API-key is disabled. Set key enable on your api-key page (https://translate.yandex.ru/developers/keys)";
				break;

			case 413:
				message = "A length of the text greater that maximum";
				break;

			case 422:
				message = "Can't translate the text.";
				break;

			case 501:
				message = "Can't translate the text from to";
				break;

			default:
				message = initMsg;
				break;
		}

		return new Exception(message);
	}
}
