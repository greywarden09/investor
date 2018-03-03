package pl.greywarden.investor.entity;

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
@Entity
public class WayOfInvest {

    @Id
    @GenericGenerator(
            name = "fund_seq",
            strategy = "sequence",
            parameters = {
                    @Parameter(name = "fund_seq", value = "sequence"),
                    @Parameter(name = "allocation_size", value = "1")
            })
    @GeneratedValue(generator = "fund_seq")
    private Long id;

    @Column(nullable = false)
    private String code;

    @ManyToOne
    private FundType fundType;

    @Column
    private Integer percentage;

}