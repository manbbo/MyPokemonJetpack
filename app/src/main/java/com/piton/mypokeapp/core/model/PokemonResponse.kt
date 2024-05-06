package com.piton.mypokeapp.core.model

import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("base_experience") val baseExperience: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("is_default") val isDefault: Boolean,
    @SerializedName("order") val order: Int,
    @SerializedName("weight") val weight: Int,
    @SerializedName("abilities") val abilities: List<Ability>,
    @SerializedName("forms") val forms: List<Form>,
    @SerializedName("game_indices") val gameIndices: List<GameIndex>,
    @SerializedName("held_items") val heldItems: List<HeldItem>,
    @SerializedName("location_area_encounters") val locationAreaEncounters: String,
    @SerializedName("moves") val moves: List<Move>,
    @SerializedName("species") val species: Species,
    @SerializedName("sprites") val sprites: Sprites,
    @SerializedName("cries") val cries: Cries,
    @SerializedName("stats") val stats: List<Stat>,
    @SerializedName("types") val types: List<Type>,
    @SerializedName("past_types") val pastTypes: List<PastType>
)

data class Ability(
    @SerializedName("is_hidden") val isHidden: Boolean,
    @SerializedName("slot") val slot: Int,
    @SerializedName("ability") val ability: AbilityDetail
)

data class AbilityDetail(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)

data class Form(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)

data class GameIndex(
    @SerializedName("game_index") val gameIndex: Int,
    @SerializedName("version") val version: Version
)

data class Version(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)

data class HeldItem(
    @SerializedName("item") val item: Item,
    @SerializedName("version_details") val versionDetails: List<VersionDetail>
)

data class Item(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)

data class VersionDetail(
    @SerializedName("rarity") val rarity: Int,
    @SerializedName("version") val version: Version
)

data class Move(
    @SerializedName("move") val move: MoveDetail,
    @SerializedName("version_group_details") val versionGroupDetails: List<VersionGroupDetail>
)

data class MoveDetail(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)

data class VersionGroupDetail(
    @SerializedName("level_learned_at") val levelLearnedAt: Int,
    @SerializedName("version_group") val versionGroup: VersionGroup,
    @SerializedName("move_learn_method") val moveLearnMethod: MoveLearnMethod
)

data class VersionGroup(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)

data class MoveLearnMethod(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)

data class Species(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)

data class Sprites(
    @SerializedName("back_default") val backDefault: String?,
    @SerializedName("back_female") val backFemale: String?,
    @SerializedName("back_shiny") val backShiny: String?,
    @SerializedName("back_shiny_female") val backShinyFemale: String?,
    @SerializedName("front_default") val frontDefault: String?,
    @SerializedName("front_female") val frontFemale: String?,
    @SerializedName("front_shiny") val frontShiny: String?,
    @SerializedName("front_shiny_female") val frontShinyFemale: String?,
    @SerializedName("other") val other: Other,
    @SerializedName("versions") val versions: Versions
)

data class Other(
    @SerializedName("dream_world") val dreamWorld: DreamWorld,
    @SerializedName("home") val home: Home,
    @SerializedName("official-artwork") val officialArtwork: OfficialArtwork,
    @SerializedName("showdown") val showdown: Showdown
)

data class DreamWorld(
    @SerializedName("front_default") val frontDefault: String?,
    @SerializedName("front_female") val frontFemale: String?
)

data class Home(
    @SerializedName("front_default") val frontDefault: String?,
    @SerializedName("front_female") val frontFemale: String?,
    @SerializedName("front_shiny") val frontShiny: String?,
    @SerializedName("front_shiny_female") val frontShinyFemale: String?
)

data class OfficialArtwork(
    @SerializedName("front_default") val frontDefault: String?,
    @SerializedName("front_shiny") val frontShiny: String?
)

data class Showdown(
    @SerializedName("back_default") val backDefault: String?,
    @SerializedName("back_female") val backFemale: String?,
    @SerializedName("back_shiny") val backShiny: String?,
    @SerializedName("back_shiny_female") val backShinyFemale: String?,
    @SerializedName("front_default") val frontDefault: String?,
    @SerializedName("front_female") val frontFemale: String?,
    @SerializedName("front_shiny") val frontShiny: String?,
    @SerializedName("front_shiny_female") val frontShinyFemale: String?
)

data class Versions(
    @SerializedName("generation-i") val generationI: GenerationI,
    @SerializedName("generation-ii") val generationII: GenerationII,
    @SerializedName("generation-iii") val generationIII: GenerationIII,
    @SerializedName("generation-iv") val generationIV: GenerationIV,
    @SerializedName("generation-v") val generationV: GenerationV,
    @SerializedName("generation-vi") val generationVI: GenerationVI,
    @SerializedName("generation-vii") val generationVII: GenerationVII,
    @SerializedName("generation-viii") val generationVIII: GenerationVIII
)

data class GenerationI(
    @SerializedName("red-blue") val redBlue: RedBlue,
    @SerializedName("yellow") val yellow: Yellow
)

data class RedBlue(
    @SerializedName("back_default") val backDefault: String?,
    @SerializedName("back_gray") val backGray: String?,
    @SerializedName("front_default") val frontDefault: String?,
    @SerializedName("front_gray") val frontGray: String?
)

data class Yellow(
    @SerializedName("back_default") val backDefault: String?,
    @SerializedName("back_gray") val backGray: String?,
    @SerializedName("front_default") val frontDefault: String?,
    @SerializedName("front_gray") val frontGray: String?
)

data class GenerationII(
    @SerializedName("crystal") val crystal: Crystal,
    @SerializedName("gold") val gold: Gold,
    @SerializedName("silver") val silver: Silver
)

data class Crystal(
    @SerializedName("back_default") val backDefault: String?,
    @SerializedName("back_shiny") val backShiny: String?,
    @SerializedName("front_default") val frontDefault: String?,
    @SerializedName("front_shiny") val frontShiny: String?
)

data class Gold(
    @SerializedName("back_default") val backDefault: String?,
    @SerializedName("back_shiny") val backShiny: String?,
    @SerializedName("front_default") val frontDefault: String?,
    @SerializedName("front_shiny") val frontShiny: String?
)

data class Silver(
    @SerializedName("back_default") val backDefault: String?,
    @SerializedName("back_shiny") val backShiny: String?,
    @SerializedName("front_default") val frontDefault: String?,
    @SerializedName("front_shiny") val frontShiny: String?
)

data class GenerationIII(
    @SerializedName("emerald") val emerald: Emerald,
    @SerializedName("firered-leafgreen") val fireredLeafgreen: FireredLeafgreen,
    @SerializedName("ruby-sapphire") val rubySapphire: RubySapphire
)

data class Emerald(
    @SerializedName("front_default") val frontDefault: String?,
    @SerializedName("front_shiny") val frontShiny: String?
)

data class FireredLeafgreen(
    @SerializedName("back_default") val backDefault: String?,
    @SerializedName("back_shiny") val backShiny: String?,
    @SerializedName("front_default") val frontDefault: String?,
    @SerializedName("front_shiny") val frontShiny: String?
)

data class RubySapphire(
    @SerializedName("back_default") val backDefault: String?,
    @SerializedName("back_shiny") val backShiny: String?,
    @SerializedName("front_default") val frontDefault: String?,
    @SerializedName("front_shiny") val frontShiny: String?
)

data class GenerationIV(
    @SerializedName("diamond-pearl") val diamondPearl: DiamondPearl,
    @SerializedName("heartgold-soulsilver") val heartgoldSoulsilver: HeartgoldSoulsilver,
    @SerializedName("platinum") val platinum: Platinum
)

data class DiamondPearl(
    @SerializedName("back_default") val backDefault: String?,
    @SerializedName("back_female") val backFemale: String?,
    @SerializedName("back_shiny") val backShiny: String?,
    @SerializedName("back_shiny_female") val backShinyFemale: String?,
    @SerializedName("front_default") val frontDefault: String?,
    @SerializedName("front_female") val frontFemale: String?,
    @SerializedName("front_shiny") val frontShiny: String?,
    @SerializedName("front_shiny_female") val frontShinyFemale: String?
)

data class HeartgoldSoulsilver(
    @SerializedName("back_default") val backDefault: String?,
    @SerializedName("back_female") val backFemale: String?,
    @SerializedName("back_shiny") val backShiny: String?,
    @SerializedName("back_shiny_female") val backShinyFemale: String?,
    @SerializedName("front_default") val frontDefault: String?,
    @SerializedName("front_female") val frontFemale: String?,
    @SerializedName("front_shiny") val frontShiny: String?,
    @SerializedName("front_shiny_female") val frontShinyFemale: String?
)

data class Platinum(
    @SerializedName("back_default") val backDefault: String?,
    @SerializedName("back_female") val backFemale: String?,
    @SerializedName("back_shiny") val backShiny: String?,
    @SerializedName("back_shiny_female") val backShinyFemale: String?,
    @SerializedName("front_default") val frontDefault: String?,
    @SerializedName("front_female") val frontFemale: String?,
    @SerializedName("front_shiny") val frontShiny: String?,
    @SerializedName("front_shiny_female") val frontShinyFemale: String?
)

data class GenerationV(
    @SerializedName("black-white") val blackWhite: BlackWhite
)

data class BlackWhite(
    @SerializedName("animated") val animated: Animated?,
    @SerializedName("back_default") val backDefault: String?,
    @SerializedName("back_female") val backFemale: String?,
    @SerializedName("back_shiny") val backShiny: String?,
    @SerializedName("back_shiny_female") val backShinyFemale: String?,
    @SerializedName("front_default") val frontDefault: String?,
    @SerializedName("front_female") val frontFemale: String?,
    @SerializedName("front_shiny") val frontShiny: String?,
    @SerializedName("front_shiny_female") val frontShinyFemale: String?
)

data class Animated(
    @SerializedName("back_default") val backDefault: String?,
    @SerializedName("back_female") val backFemale: String?,
    @SerializedName("back_shiny") val backShiny: String?,
    @SerializedName("back_shiny_female") val backShinyFemale: String?,
    @SerializedName("front_default") val frontDefault: String?,
    @SerializedName("front_female") val frontFemale: String?,
    @SerializedName("front_shiny") val frontShiny: String?,
    @SerializedName("front_shiny_female") val frontShinyFemale: String?
)

data class GenerationVI(
    @SerializedName("omegaruby-alphasapphire") val omegarubyAlphasapphire: OmegarubyAlphasapphire,
    @SerializedName("x-y") val xY: XY
)

data class OmegarubyAlphasapphire(
    @SerializedName("front_default") val frontDefault: String?,
    @SerializedName("front_female") val frontFemale: String?,
    @SerializedName("front_shiny") val frontShiny: String?,
    @SerializedName("front_shiny_female") val frontShinyFemale: String?
)

data class XY(
    @SerializedName("front_default") val frontDefault: String?,
    @SerializedName("front_female") val frontFemale: String?,
    @SerializedName("front_shiny") val frontShiny: String?,
    @SerializedName("front_shiny_female") val frontShinyFemale: String?
)

data class GenerationVII(
    @SerializedName("icons") val icons: Icons,
    @SerializedName("ultra-sun-ultra-moon") val ultraSunUltraMoon: UltraSunUltraMoon
)

data class Icons(
    @SerializedName("front_default") val frontDefault: String?,
    @SerializedName("front_female") val frontFemale: String?
)

data class UltraSunUltraMoon(
    @SerializedName("front_default") val frontDefault: String?,
    @SerializedName("front_female") val frontFemale: String?,
    @SerializedName("front_shiny") val frontShiny: String?,
    @SerializedName("front_shiny_female") val frontShinyFemale: String?
)

data class GenerationVIII(
    @SerializedName("icons") val icons: Icons
)

data class Cries(
    @SerializedName("latest") val latest: String?,
    @SerializedName("legacy") val legacy: String?
)

data class Stat(
    @SerializedName("base_stat") val baseStat: Int,
    @SerializedName("effort") val effort: Int,
    @SerializedName("stat") val stat: StatDetail
)

data class StatDetail(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)

data class Type(
    @SerializedName("slot") val slot: Int,
    @SerializedName("type") val type: TypeDetail
)

data class TypeDetail(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)

data class PastType(
    @SerializedName("generation") val generation: Generation,
    @SerializedName("types") val types: List<Type>
)

enum class Generation {
    @SerializedName("generation-i") GENERATION_I,
    @SerializedName("generation-ii") GENERATION_II,
    @SerializedName("generation-iii") GENERATION_III,
    @SerializedName("generation-iv") GENERATION_IV,
    @SerializedName("generation-v") GENERATION_V,
    @SerializedName("generation-vi") GENERATION_VI,
    @SerializedName("generation-vii") GENERATION_VII,
    @SerializedName("generation-viii") GENERATION_VIII
}