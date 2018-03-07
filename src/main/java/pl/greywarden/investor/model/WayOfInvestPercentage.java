package pl.greywarden.investor.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity(name = "way_of_invest_percentage")
public class WayOfInvestPercentage {

    @Id
    @GenericGenerator(
            name = "way_of_invest_percentage_seq",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence", value = "way_of_invest_percentage_seq"),
                    @Parameter(name = "increment_size", value = "1")
            })
    @GeneratedValue(generator = "way_of_invest_percentage_seq")
    private Long id;

    @ManyToOne(optional = false)
    private FundType fundType;

    @ManyToOne
    private WayOfInvest wayOfInvest;

    @Column(nullable = false)
    private Integer percentage;
}
