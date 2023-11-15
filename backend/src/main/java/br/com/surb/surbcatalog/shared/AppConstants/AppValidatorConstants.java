package br.com.surb.surbcatalog.shared.AppConstants;

public final class AppValidatorConstants {

  public static final String ROOM_NAME = ".name";
  public static final int MIN_LENGTH = 20;
  public static final int MAX_LENGTH = 20;

  public static final String ROOM_SEATS = ".seats";
  public static final int MIN_VALUE = 1;
  public static final int MAX_VALUE = 20;
  public static Integer SIZE_MIN = 5;
  public static Integer SIZE_MAX = 60;

  public static final String MISSING = ".missing";
  public static final String BELOW_MIN_VALUE = ".belowMinValue";

  public static final String DUPLICATE = "Error: Esse campo duplicate";

  public static final String REQUIRED_FIELD = "Error: Esse campo é de preenchimento obrigatório";
  //public static final String REQUIRED_EMAIL = "Favor entrar um email válido";
  public static final String REQUIRED_PHONE = "Error: O campo Telefone deve conter apenas dígitos";
  public static final String REQUIRED_EMAIL = "Error: O endereço usado no campo Email não é um endereço de e-mail válido";
  public static final String REQUIRED_NUMBER = "Error: O campo aceitar apenas números positivo e não letras";
  public static final String REQUIRED_EMAIL_EXIST = "Error: Email já existe";
  public static final String REQUIRED_EXIST = "Error: Já existe em nossa base de dados";
  public static final String REQUIRED_PRICE_POSITIVO = "Error: Preço deve ser um valor positivo";
  public static final String REQUIRED_DATA_PRESENT = "Error: A data do produto não pode ser futura";

  public static final String MAX = "Error: Campo deve ser menor que";
  public static final String MIN = "Error: Campo deve ser maior que";


  private AppValidatorConstants(){}
}
