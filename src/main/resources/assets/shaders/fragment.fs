#version 330

in  vec4 outColour;
in  vec2 outTexCoord;

out vec4 fragColor;

uniform sampler2D texture_sampler;

void main()
{
    fragColor = texture(texture_sampler, outTexCoord);
}