package pl.greywarden.investor.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity(name = "fund_type")
public class FundType {

    @Id
    @GenericGenerator(
            name = "fund_type_seq",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence", value = "fund_type_seq"),
                    @Parameter(name = "increment_size", value = "1")
            })
    @GeneratedValue(generator = "fund_type_seq")
    private Long id;

    @Column(unique = true)
    private String name;

}
