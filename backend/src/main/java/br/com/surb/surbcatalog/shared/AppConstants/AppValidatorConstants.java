package br.com.surb.surbcatalog.shared.AppConstants;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AppValidatorConstants {
  public static final String ROOM_NAME = ".name";
  public static final int MIN_LENGTH = 20;
  public static final int MAX_LENGTH = 20;

  public static final String ROOM_SEATS = ".seats";
  public static final int MIN_VALUE = 1;
  public static final int MAX_VALUE = 20;

  public static final String MISSING = ".missing";
  public static final String EXCEEDS_MAX_LENGTH = ".exceedsMaxLength";
  public static final String EXCEEDS_MAX_VALUE = ".exceedsMaxValue";
  public static final String BELOW_MIN_VALUE = ".belowMinValue";

  public static final String DUPLICATE = ".duplicate";

  public static final String REQUIRED_FIELD = ".Campo obrigatório";
  public static final String REQUIRED_EMAIL = ".Favor entrar um email válido";
  public static final String FIELD_VALID = ".Campo inválido";
  public static final String REQUIRED_EMAIL_EXIST = ".Email já existe";
  public static final String REQUIRED_NAME_EXIST = ".Nome já existe";
  public static final String REQUIRED_PRICE_POSITIVO = ".Preço deve ser um valor positivo";
  public static final String REQUIRED_DATA_PRESENT = ".A data do produto não pode ser futura";
  public static final Integer SIZE_MIN = 5;
  public static final Integer SIZE_MAX = 60;
  public static final String REQUIRED_SIZE_MESSAGE = ".Deve ter entre 5 e 60 caracteres";
}
