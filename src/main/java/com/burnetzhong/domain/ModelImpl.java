package com.burnetzhong.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@XmlType(propOrder = {"type", "required", "discriminator", "properties"})
@JsonPropertyOrder({"type", "required", "discriminator", "properties"})
public class ModelImpl extends AbstractModel {
    public static final String OBJECT = "object";
    private String type;
    private String format;
    private String name;
    private List<String> required;
    private Map<String, Object> properties;
    private boolean isSimple = false;
    private String description;
    private Object example;
    private Object additionalProperties;
    private String discriminator;
    private Xml xml;
    @JsonProperty("default")
    private String defaultValue;
    private List<String> _enum;

    public ModelImpl _enum(List<String> value) {
        this._enum = value;
        return this;
    }

    public ModelImpl _enum(String value) {
        if(this._enum == null) {
            this._enum = new ArrayList<String>();
        }
        this._enum.add(value);
        return this;
    }

    public List<String> getEnum() {
        return _enum;
    }

    public void setEnum(List<String> _enum) {
        this._enum = _enum;
    }


    public ModelImpl discriminator(String discriminator) {
        this.setDiscriminator(discriminator);
        return this;
    }

    public ModelImpl type(String type) {
        this.setType(type);
        return this;
    }

    public ModelImpl format(String format) {
        this.setFormat(format);
        return this;
    }

    public ModelImpl name(String name) {
        this.setName(name);
        return this;
    }

    public ModelImpl description(String description) {
        this.setDescription(description);
        return this;
    }


    public ModelImpl example(Object example) {
        this.setExample(example);
        return this;
    }

    public ModelImpl additionalProperties(Object additionalProperties) {
        this.setAdditionalProperties(additionalProperties);
        return this;
    }

    public ModelImpl xml(Xml xml) {
        this.setXml(xml);
        return this;
    }

    public String getDiscriminator() {
        return this.discriminator;
    }

    public void setDiscriminator(String discriminator) {
        this.discriminator = discriminator;
    }

    @JsonIgnore
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonIgnore
    public boolean isSimple() {
        return isSimple;
    }

    public void setSimple(boolean isSimple) {
        this.isSimple = isSimple;
    }

    public Object getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Object additionalProperties) {
        type(OBJECT);
        this.additionalProperties = additionalProperties;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }



    public Map<String, Object> getProperties() {
        return properties;
    }

    @Override
    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    public Object getExample() {
        if (example == null) {
            // TODO: will add logic to construct examples based on payload here
        }

        return example;
    }

    public void setExample(Object example) {
        this.example = example;
    }

    public Xml getXml() {
        return xml;
    }

    public void setXml(Xml xml) {
        this.xml = xml;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public Object clone() {
        ModelImpl cloned = new ModelImpl();
        super.cloneTo(cloned);
        cloned.type = this.type;
        cloned.name = this.name;
        cloned.required = this.required;
        if (this.properties != null) cloned.properties = new LinkedHashMap<>(this.properties);
        cloned.isSimple = this.isSimple;
        cloned.description = this.description;
        cloned.example = this.example;
        cloned.additionalProperties = this.additionalProperties;
        cloned.discriminator = this.discriminator;
        cloned.xml = this.xml;
        cloned.defaultValue = this.defaultValue;

        return cloned;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime
                * result
                + ((additionalProperties == null) ? 0 : additionalProperties
                .hashCode());
        result = prime * result
                + ((description == null) ? 0 : description.hashCode());
        result = prime * result
                + ((discriminator == null) ? 0 : discriminator.hashCode());
        result = prime * result + ((example == null) ? 0 : example.hashCode());
        result = prime * result + ((format == null) ? 0 : format.hashCode());
        result = prime * result + (isSimple ? 1231 : 1237);
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result
                + ((properties == null) ? 0 : properties.hashCode());
        result = prime * result + ((required == null) ? 0 : required.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((xml == null) ? 0 : xml.hashCode());
        result = prime * result + ((defaultValue == null) ? 0 : defaultValue.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ModelImpl other = (ModelImpl) obj;
        if (additionalProperties == null) {
            if (other.additionalProperties != null) {
                return false;
            }
        } else if (!additionalProperties.equals(other.additionalProperties)) {
            return false;
        }
        if (description == null) {
            if (other.description != null) {
                return false;
            }
        } else if (!description.equals(other.description)) {
            return false;
        }
        if (discriminator == null) {
            if (other.discriminator != null) {
                return false;
            }
        } else if (!discriminator.equals(other.discriminator)) {
            return false;
        }
        if (example == null) {
            if (other.example != null) {
                return false;
            }
        } else if (!example.equals(other.example)) {
            return false;
        }
        if (format == null) {
            if (other.format != null) {
                return false;
            }
        } else if (!format.equals(other.format)) {
            return false;
        }
        if (isSimple != other.isSimple) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (properties == null) {
            if (other.properties != null) {
                return false;
            }
        } else if (!properties.equals(other.properties)) {
            return false;
        }
        if (required == null) {
            if (other.required != null) {
                return false;
            }
        } else if (!required.equals(other.required)) {
            return false;
        }
        if (type == null) {
            if (other.type != null) {
                return false;
            }
        } else if (!type.equals(other.type)) {
            return false;
        }
        if (xml == null) {
            if (other.xml != null) {
                return false;
            }
        } else if (!xml.equals(other.xml)) {
            return false;
        }
        if (defaultValue == null) {
            if (other.defaultValue != null) {
                return false;
            }
        } else if (!defaultValue.equals(other.defaultValue)) {
            return false;
        }
        return true;
    }
}
