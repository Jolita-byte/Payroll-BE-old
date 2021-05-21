package lt.Payroll.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "contract_line")
public class ContractLine {
    public enum AmountType{
        MONTHLY,
        HOURLY,
    }
//https://thorben-janssen.com/hibernate-enum-mappings/
    @Converter(autoApply=true)
    public class AmountTypeConverter implements AttributeConverter<AmountType, String> {

        @Override
        public String convertToDatabaseColumn(AmountType attribute) {
            if (attribute == null)
                return null;

            switch (attribute) {
                case MONTHLY:
                    return "Monthly";

                case HOURLY:
                    return "Hourly";

                default:
                    throw new IllegalArgumentException(attribute + " not supported.");
            }
        }

        @Override
        public AmountType convertToEntityAttribute(String dbData) {
            if (dbData == null)
                return null;

            switch (dbData) {
                case "Monthly":
                    return AmountType.MONTHLY;

                case "Hourly":
                    return AmountType.HOURLY;

                default:
                    throw new IllegalArgumentException(dbData + " not supported.");
            }
        }

    }

    @EmbeddedId
    private ContractLineID id;

    @ManyToOne
    @JoinColumn(name="schedule_id", nullable=false)
    private Schedule schedule;

    @ManyToOne
    @JoinColumn(name="position_id", nullable=false)
    private Position position;

    private Integer staff;

    @Enumerated(EnumType.STRING) //--turbūt nereikialinas
    @Convert(converter = AmountTypeConverter.class)//laikinai užkomentuotia
    private ContractLine.AmountType amount_type;//laikinai užkomentuotia

    private Float amount;


}
