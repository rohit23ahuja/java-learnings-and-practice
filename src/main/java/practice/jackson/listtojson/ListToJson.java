package practice.jackson.listtojson;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ListToJson {

	private static final String rockets = ":rocket::rocket::rocket::rocket:";
	private static final String newline = "\n";
	private static final String eventdetails = "Event Details :-";

	public static void main(String[] args) {
		SlackNotification slackNotification = ImmutableSlackNotification.builder()
				.eventDescription(String.format("Release #%s was Created.", "38"))
				.eventData(
						"{\"casino_groups\":[\"US-MI\"],\"schedule_time\":\"2022-12-25T12:35:02.000Z\",\"environment\":\"EXTERNAL_TEST\",\"user\":\"rahuja@evolution.com\",\"game_ids\":[\"fruitshop_mobile_html\",\"fruitshop_not_mobile\",\"fruitshop_r0_mobile_html\",\"fruitshop_r0_not_mobile\",\"fruitshop_r1_mobile_html\",\"fruitshop_r1_not_mobile\",\"fruitshop_r2_mobile_html\",\"fruitshop_r2_not_mobile\",\"fruitshop_r3_mobile_html\",\"fruitshop_r3_not_mobile\",\"fruitshop_r4_mobile_html\",\"fruitshop_r4_not_mobile\",\"fruitshop_r6_mobile_html\",\"fruitshop_r6_not_mobile\",\"fruitshop_r7_mobile_html\",\"fruitshop_r7_not_mobile\",\"hotline_mobile_html\",\"hotline_not_mobile\",\"turnyourfortune_mobile_html\",\"turnyourfortune_not_mobile\",\"twinspin_mobile_html\",\"twinspin_not_mobile\",\"twinspin_r0_mobile_html\",\"twinspin_r0_not_mobile\",\"twinspin_r1_mobile_html\",\"twinspin_r1_not_mobile\",\"twinspin_r2_mobile_html\",\"twinspin_r2_not_mobile\",\"twinspin_r3_mobile_html\",\"twinspin_r3_not_mobile\",\"twinspin_r4_mobile_html\",\"twinspin_r4_not_mobile\",\"twinspin_r5_mobile_html\",\"twinspin_r5_not_mobile\",\"twinspin_r6_mobile_html\",\"twinspin_r6_not_mobile\"]}")
				.build();
		ListToJson listToJson = new ListToJson();
		List<? super SlackBlock> blocks = listToJson.createSlackBlocks(slackNotification);
		listToJson.convertObjectToJsonString(blocks);
	}

	public List<? super SlackBlock> createSlackBlocks(SlackNotification slackNotification) {
		List<? super SlackBlock> blocks = new ArrayList<>();
		Section section = ImmutableSection
				.builder().text(
						ImmutableMrkdwnTxt.builder()
								.text(StringUtils.join(rockets, newline, slackNotification.getEventDescription(),
										newline, eventdetails, newline, slackNotification.getEventData()))
								.build())
				.build();

		blocks.add(section);
		blocks.add(ImmutableDivider.builder().build());
		return blocks;
	}

	public String convertObjectToJsonString(Object requestObject) {
		String jsonString = null;
		try {
			if (requestObject != null) {
				ObjectMapper objectMapper = new ObjectMapper();
				jsonString = objectMapper.writeValueAsString(requestObject);
			}
		} catch (JsonProcessingException exception) {
			jsonString = requestObject.toString();
			log.error("Error occurred while converting request object : {} to json string", requestObject.toString());
		}
		return jsonString;
	}
}
