package study.cursach.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Validation {
    private String passport;
    private String entry;
    private String work = "Not included";
    private String declaration = "Not included";
    private String criminal;
}
