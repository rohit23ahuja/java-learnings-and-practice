package practice.jackson.listtojson;

import org.immutables.value.Value;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableSlackPayload.class)
@JsonDeserialize(builder = ImmutableSlackPayload.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class SlackPayload {
    public abstract String getText();

}
