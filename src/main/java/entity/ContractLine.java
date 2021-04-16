package entity;

import javax.persistence.*;

@Entity
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
    @JoinColumn(name="schedule_code_id", nullable=false)
    private ScheduleCode schedule_code;

    @ManyToOne
    @JoinColumn(name="position_code_id", nullable=false)
    private PositionCode position_code;

    private Integer staff;

    //@Enumerated(EnumType.STRING)
    @Convert(converter = AmountTypeConverter.class)
    private ContractLine.AmountType amount_type;

    private Float amount;

    public ContractLine() {
    }

    public ContractLine(ContractLineID id, ScheduleCode schedule_code, PositionCode position_code, Integer staff, AmountType amount_type, Float amount) {
        this.id = id;
        this.schedule_code = schedule_code;
        this.position_code = position_code;
        this.staff = staff;
        this.amount_type = amount_type;
        this.amount = amount;
    }

    public ContractLineID getId() {
        return id;
    }

    public void setId(ContractLineID id) {
        this.id = id;
    }

    public ScheduleCode getSchedule_code() {
        return schedule_code;
    }

    public void setSchedule_code(ScheduleCode schedule_code) {
        this.schedule_code = schedule_code;
    }

    public PositionCode getPosition_code() {
        return position_code;
    }

    public void setPosition_code(PositionCode position_code) {
        this.position_code = position_code;
    }

    public Integer getStaff() {
        return staff;
    }

    public void setStaff(Integer staff) {
        this.staff = staff;
    }

    public AmountType getAmount_type() {
        return amount_type;
    }

    public void setAmount_type(AmountType amount_type) {
        this.amount_type = amount_type;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "\nContractLine{" +
                "id=" + id +
                ", schedule_code=" + schedule_code +
                ", position_code=" + position_code +
                ", staff=" + staff +
                ", amount_type=" + amount_type +
                ", amount=" + amount +
                '}';
    }
}
