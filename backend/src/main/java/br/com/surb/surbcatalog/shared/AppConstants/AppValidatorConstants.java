package br.com.surb.surbcatalog.shared.AppConstants;

public final class AppValidatorConstants {

  private AppValidatorConstants(){}

  public static Integer SIZE_MIN = 5;
  public static Integer SIZE_MAX = 60;

  public static final String MISSING = ".missing";
  public static final String BELOW_MIN_VALUE = ".belowMinValue";

  public static final String DUPLICATE = " Esse campo duplicate. ";

  public static final String REQUIRED_FIELD = " Esse campo é de preenchimento obrigatório. ";
  //public static final String REQUIRED_EMAIL = "Favor entrar um email válido";
  public static final String REQUIRED_PHONE = " O campo Telefone deve conter apenas dígitos. ";
  public static final String INVALID_EMAIL = " O endereço usado no campo Email não é um endereço de e-mail válido. ";
  public static final String REQUIRED_NUMBER = " O campo aceitar apenas números positivo e não letras ";
  public static final String REQUIRED_EMAIL_EXIST = " já existe em nossa base de dados. ";
  public static final String REQUIRED_EXIST = " Já existe em nossa base de dados. ";
  public static final String NAME_EXIST = " Já existe em nossa base de dados. ";
  public static final String REQUIRED_PRICE_POSITIVO = " Preço deve ser um valor positivo. ";
  public static final String REQUIRED_DATA_PRESENT = " A data do produto não pode ser futura. ";
  public static final String INVALID = " invalid format. ";
  public static final String ORDER_BY = " orderBy. ";

  public static final String MAX_LENGTH = " Campo deve ser menor que ";
  public static final String MIN_LENGTH = " Campo deve ser maior que ";
  public static final String MAX_VALUE = " Campo deve ser menor que ";
  public static final String MIN_VALUE = " Campo deve ser maior que ";
  public static final String MIN_MAX = " Campo deve ter entre 5 e 15 caracteres. ";
  public static final String BETWEEN_LENGTH = " Campo deve ter entre 5 e 15 caracteres. ";

  public static final String INVALID_ORDER_DATE = " Order data inválida. ";
  public static final String IN_THE_PAST = " data no passado. ";
  public static final String EXCEEDS_DURATION = " excede a duração. ";
  public static final String OVERLAPS = " comflito de datas. ";

}
