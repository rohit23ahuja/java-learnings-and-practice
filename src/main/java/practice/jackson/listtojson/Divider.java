package practice.jackson.listtojson;

import org.immutables.value.Value;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableDivider.class)
@JsonDeserialize(builder = ImmutableDivider.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Divider extends SlackBlock {

    @Value.Default
    public String getType() {
        return "divider";
    }

}
