package br.com.surb.surbcatalog.shared.AppConstants;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AppMessageConstants {
  public static final String REQUIRED_FIELD = ".Campo obrigatório";
  public static final String REQUIRED_EMAIL = ".Favor entrar um email válido";
  public static final String REQUIRED_EMAIL_EXIST = ".Email já existe";
  public static final String REQUIRED_PRICE_POSITIVO = ".Preço deve ser um valor positivo";
  public static final String REQUIRED_DATA_PRESENT = ".A data do produto não pode ser futura";
  public static final Integer REQUIRED_SIZE_MIN = 5;
  public static final Integer REQUIRED_SIZE_MAX = 60;
  public static final String REQUIRED_SIZE_MESSAGE = ".Deve ter entre 5 e 60 caracteres";
}
