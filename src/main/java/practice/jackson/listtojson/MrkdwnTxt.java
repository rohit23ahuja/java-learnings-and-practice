package practice.jackson.listtojson;

import org.immutables.value.Value;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableMrkdwnTxt.class)
@JsonDeserialize(builder = ImmutableMrkdwnTxt.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class MrkdwnTxt {

    @Value.Default
    public String getType() {
        return "mrkdwn";
    }
    public abstract String getText();
}
