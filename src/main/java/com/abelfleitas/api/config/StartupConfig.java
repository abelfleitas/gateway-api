package com.abelfleitas.api.config;

import com.abelfleitas.api.models.Device;
import com.abelfleitas.api.models.Gateway;
import com.abelfleitas.api.response.DeviceResponse;
import com.abelfleitas.api.response.GatewayResponse;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class StartupConfig {

  @Bean
  public OpenAPI springShopOpenAPI() {
      return new OpenAPI()
              .info(new Info().title("API Gateways")
              .description("API Gateways")
              .version("v0.0.1"));
              
  }

  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer(){
        @Override
        public void addCorsMappings(CorsRegistry registry) {
          registry.addMapping("/**")
              .allowedOrigins("http://localhost:8080", "http://localhost:4200")
              .allowedMethods("GET", "POST", "UPDATE", "DELETE", "PUT", "PATCH");
        }
    };     
  }

  @Bean
  public ModelMapper modelMapper() {
    ModelMapper modelMapper = new ModelMapper();
    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    mapEntitiesToDTO(modelMapper);
    return modelMapper;
  }

  private void mapEntitiesToDTO(final ModelMapper modelMapper){
    modelMapper.createTypeMap(Gateway.class, GatewayResponse.class);
    modelMapper.createTypeMap(Device.class, DeviceResponse.class);
    // .addMappings(
    //   mapper -> mapper.map(Device::gateway, DeviceResponse::gatewayid)
    // );
  }

}
